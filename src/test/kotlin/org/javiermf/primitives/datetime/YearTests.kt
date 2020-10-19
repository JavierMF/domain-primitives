package org.javiermf.primitives.datetime

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class YearTests {

    private fun assertValid(value: Int) = Assertions.assertNotNull(Year(value))
    private fun assertInvalid(value: Int) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { Year(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [
        2020,
        0,
        -30,
    ])
    fun `valid | valid year`(value : Int) = assertValid(value)

    @ParameterizedTest
    @ValueSource(ints = [
        Int.MIN_VALUE,
        4000,
        Int.MAX_VALUE,
    ])
    fun `invalid | invalid year`(value : Int) = assertInvalid(value)

    @Test
    fun `equal years`() = assertTrue(Year(2020) == Year(2020))

    @Test
    fun `string year`() = assertEquals("2020", "${Year(2020)}")
}