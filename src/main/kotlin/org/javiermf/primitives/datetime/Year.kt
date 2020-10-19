package org.javiermf.primitives.datetime

data class Year(val year: Int) {

    init {
        require( year in MIN_YEAR..MAX_YEAR ) { "Year is out of range"}
    }

    val value get() = year

    override fun toString() = value.toString()

    companion object {
        val MIN_YEAR = -9_000_000
        val MAX_YEAR = 3000 // Remember to update this when year 3000 is approaching
    }
}