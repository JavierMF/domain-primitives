package org.javiermf.primitives.isbn

data class Isbn(val isbn: String) {

    val value: String = isbn.trim().replace("-", "").replace(" ", "")

    val original = isbn

    init {
        require(value.length in setOf(10, 13)) { "The isbn has not the proper length (10 or 13)" }
        require( isValid(value) ){ "The isbn is invalid" }
    }

    override fun toString() = original

    override fun equals(other: Any?) = other is Isbn && other.value == this.value

    override fun hashCode() = value.hashCode()

    private fun isValid(trimedIsbn: String) =
            if (trimedIsbn.length == 10)
                isValidIsbn10(trimedIsbn) else
                isValidIsbn13(trimedIsbn)

    private fun isValidIsbn13(trimedIsbn: String)=
            trimedIsbn.map { it - '0' }
                    .mapIndexed { index, value ->
                        when (index % 2) {
                            0 -> value
                            else -> 3 * value
                        }
                    }
                    .sum() % 10 == 0

    private fun isValidIsbn10(trimedIsbn: String): Boolean {
        // all core isbn must be numbers
        trimedIsbn.dropLast(1).toIntOrNull() ?: return false

        // checkDigit is a number or an X
        trimedIsbn.last().takeIf { it.isDigit() || it == 'X' } ?: return false

        val sum = trimedIsbn
                .map { if (it == 'X') 10 else it - '0' }
                .foldIndexed(0){ ind, acc, n -> acc + (10 - ind) * n }

        return (sum % 11) == 0
    }
}

