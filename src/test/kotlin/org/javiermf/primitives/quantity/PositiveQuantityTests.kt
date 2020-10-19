package org.javiermf.primitives.quantity

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveQuantityTests {

    private fun assertValid(value: Int) = Assertions.assertNotNull(PositiveQuantity(value))
    private fun assertInvalid(value: Int) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { PositiveQuantity(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [
        0,
        3,
        200,
        Int.MAX_VALUE
    ])
    fun `valid | valid quantity`(value : Int) = assertValid(value)

    @ParameterizedTest
    @ValueSource(ints = [
        Int.MIN_VALUE,
        -1,
        -30,
    ])
    fun `invalid | invalid quantity`(value : Int) = assertInvalid(value)

    @Test
    fun `equal quantities`() = assertTrue(PositiveQuantity(3) == PositiveQuantity(3))

    @Test
    fun `string quantity`() = assertEquals("3", "${PositiveQuantity(3)}")
}