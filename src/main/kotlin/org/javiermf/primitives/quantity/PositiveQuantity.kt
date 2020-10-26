package org.javiermf.primitives.quantity

import org.javiermf.primitives.exceptions.message

data class PositiveQuantity(val value: Int) {

    init {
        require( value >= 0 ) { message("Quantity must be a positive integer") }
    }

    override fun toString() = value.toString()
}