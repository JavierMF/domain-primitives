package org.javiermf.primitives.slug

data class Slug(private val slug: String) {

    init {
        require( slug.length < 2000 ) { "Slug too long" }
        require( slugRegex matches slug ) { "The string is not a valid slug" }
    }

    val value get() = slug

    override fun toString() = value

    companion object {
        val slugRegex = "[a-z0-9]+(-[a-z0-9]+)*".toRegex()
    }
}