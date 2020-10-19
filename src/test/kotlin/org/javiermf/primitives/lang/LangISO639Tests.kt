package org.javiermf.primitives.lang

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LangISO639Tests {

    private fun assertValid(code: String) = Assertions.assertNotNull(LangISO639(code))
    private fun assertInvalid(code: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { LangISO639(code) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "es",
        "spa",
        "cat",
        "lad",
    ])
    fun `valid | valid lang`(code : String) = assertValid(code)

    @ParameterizedTest
    @ValueSource(strings = [
        "-",
        "",
        "lc",
        "a-random-text",
    ])
    fun `invalid | invalid code`(code : String) = assertInvalid(code)

    @Test
    fun `invalid | extreme length`() = assertInvalid("a-a".repeat(100000))

    @Test
    fun `equal lang`() = assertTrue(LangISO639("es") == LangISO639("es"))

    @Test
    fun `string lang`() = assertEquals("es", "${LangISO639("es")}")

}