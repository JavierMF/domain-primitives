package org.javiermf.primitives.slug

data class Slug(private val slug: String) {

    private val slugRegex = "[a-z0-9]+(-[a-z0-9]+)*".toRegex()

    init {
        require( slug.length < 2000 ) { "Slug too logn" }
        require( slugRegex matches slug ) { "The string is not a valid slug" }
    }

    val value get() = slug

    override fun toString() = value
}