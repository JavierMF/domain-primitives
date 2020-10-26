package org.javiermf.primitives.datetime

import org.javiermf.primitives.exceptions.message

data class Year(val year: Int) {

    init {
        require( year in MIN_YEAR..MAX_YEAR ) { message("Year is out of range") }
    }

    val value get() = year

    override fun toString() = value.toString()

    companion object {
        const val MIN_YEAR = -9_000_000
        const val MAX_YEAR = 3000 // Remember to update this when year 3000 is approaching
    }
}