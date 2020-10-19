package org.javiermf.primitives.quantity

data class PositiveQuantity(val value: Int) {

    init {
        require( value >= 0 ) { "Quantity must be a positive integer"}
    }

    override fun toString() = value.toString()
}