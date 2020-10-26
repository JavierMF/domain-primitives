package org.javiermf.primitives.exceptions

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExceptionMessageTests {

    private fun assertValid(message: String) = Assertions.assertNotNull(ExceptionMessage(message))
    private fun assertInvalid(message: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { ExceptionMessage(message) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "A message",
        "A message with number 23",
        "This is an error. Please, fix it",
        "Range 0-100 exceeded",
        "Error: a   b   c"
    ])
    fun `valid | valid hash`(message : String) = assertValid(message)

    @ParameterizedTest
    @ValueSource(strings = [
        "",
        " ",
        "Exception with #",
        "This & that",
        "Not all%owed char",
        "error; drop database;",
        "Error in <html>"
    ])
    fun `invalid | invalid message`(message : String) = assertInvalid(message)

    @Test
    fun `invalid | extreme length`() = assertEquals(ExceptionMessage("a".repeat(500)), ExceptionMessage("aa".repeat(100000)))

    @Test
    fun `equal hash`() = Assertions.assertTrue(ExceptionMessage("A message") == ExceptionMessage("A message"))

    @Test
    fun `string hash`() = Assertions.assertEquals("A message", "${ExceptionMessage("A message")}")

}