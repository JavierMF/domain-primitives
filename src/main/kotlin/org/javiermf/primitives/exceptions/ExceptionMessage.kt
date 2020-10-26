package org.javiermf.primitives.exceptions

data class ExceptionMessage(private val message: String) {

    val value = if (message.length >= MAX_EXCEPTION_MESSAGE_LENGTH )
        message.substring(0, MAX_EXCEPTION_MESSAGE_LENGTH) else
        message

    init {
        require ( value.isNotBlank() ) { message("Message can not be empty") }
        require( EXCEPTION_MESSAGE_REGEX.matches(value) ) { message("Invalid exception message") }
    }

    override fun toString() = value

    override fun equals(other: Any?) =
            other is ExceptionMessage && other.hashCode() == this.hashCode()
    override fun hashCode() = value.hashCode()

    companion object {
        const val MAX_EXCEPTION_MESSAGE_LENGTH = 500
        val EXCEPTION_MESSAGE_REGEX = "[\\w ,.:_\\t-]+".toRegex()
    }
}

typealias message = ExceptionMessage