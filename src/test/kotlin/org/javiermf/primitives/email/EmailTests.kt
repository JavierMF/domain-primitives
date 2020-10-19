package org.javiermf.primitives.email

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EmailTests {

    private fun assertValid(email: String) = assertNotNull(Email(email))
    private fun assertInvalid(email: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { Email(email) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "email@example.com",
        "firstname.lastname@example.com",
        "email@subdomain.example.com",
        "firstname+lastname@example.com",
        "email@123.123.123.123",
        "email@[123.123.123.123]",
        "\"email\"@example.com",
        "1234567890@example.com",
        "email@example-one.com",
        "_______@example.com",
        "email@example.name",
        "firstname-lastname@example.com",
        "a@a.a"
    ])
    fun `valid | valid simple email`(email : String) = assertValid(email)

    @ParameterizedTest
    @ValueSource(strings = [
        "plainaddress",
        "#@%^%#\$@#\$@#.com",
        "@example.com",
        "Joe Smith <email@example.com>",
        "email.example.com",
        "email@example@example.com",
        ".email@example.com",
        "email.@example.com",
        "email..email@example.com",
        "あいうえお@example.com",
        "email@example.com (Joe Smith)",
        "email@example",
        "email@-example.com",
        "email@example..com",
        "Abc..123@example.com",
    ])
    fun `invalid | invalid email`(email : String) = assertInvalid(email)

    @Test
    fun `invalid | invalid extreme`() = assertInvalid("9".repeat(1000000))

    @Test
    fun `equal emails`() = assertTrue(Email("email@example.com") == Email("email@example.com"))

    @Test
    fun `string email`() = assertEquals("email@example.com", "${Email("email@example.com")}")

}