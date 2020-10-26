package org.javiermf.primitives.auth

import org.javiermf.primitives.exceptions.message

data class SHA1Hash(private val hashHex: String) {

    val value = hashHex.toLowerCase()
    val byteArray get() = value.chunked(2).map { it.toInt(16).toByte() }.toByteArray()

    init {
        require( hashHex.length == 40 ) { message("Hash must be 40 characters long") }
        require( PASSWORD_SHA1HASH_REGEX.matches(value)) { message("Hash must be an hex string") }
    }

    override fun equals(other: Any?) =
            other is SHA1Hash && other.value == this.value

    override fun hashCode() = value.hashCode()

    override fun toString() = value

    companion object {
        val PASSWORD_SHA1HASH_REGEX = "[0-9a-f]{40}".toRegex()
    }
}