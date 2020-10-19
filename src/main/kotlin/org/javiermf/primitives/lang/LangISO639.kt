package org.javiermf.primitives.lang

data class LangISO639(private val code: String) {

    private val normalizedCode : String
    val description : String

    init {
        require( code.length in 2..8 ) { "Language code length must be between 2 and 8 characters"}
        require( iso639Regex matches code ) { "The string is not a valid ISO 639 language code" }

        val lowerCasedCode = code.toLowerCase()

        normalizedCode = ISO639Codes.alpha3[lowerCasedCode] ?: lowerCasedCode
        val descriptionForCode = ISO639Codes.descriptionForCode(normalizedCode)

        require( descriptionForCode != null ) { "The string is not a valid ISO 639 language code" }

        description = descriptionForCode
    }

    val value get() = normalizedCode

    override fun equals(other: Any?) = other is LangISO639 && other.normalizedCode == this.normalizedCode

    override fun hashCode() = normalizedCode.hashCode()

    override fun toString() = value

    companion object {
        val iso639Regex = "[a-zA-Z]{2,8}".toRegex()
    }
}

