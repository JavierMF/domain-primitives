package org.javiermf.primitives.slug

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SlugTests {

    private fun assertValid(slug: String) = Assertions.assertNotNull(Slug(slug))
    private fun assertInvalid(slug: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { Slug(slug) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "slug",
        "a",
        "a-slug",
        "a-slug-with-some-words-in-it-so-it-is-long-but-not-too-much",
        "a-slug-with-numb3rs-2",
        "22"
    ])
    fun `valid | valid simple slug`(slug : String) = assertValid(slug)

    @ParameterizedTest
    @ValueSource(strings = [
        "-",
        "",
        "a--slug",
        "a-slug-",
        "a- slug",
        "a-sl#ug-l"
    ])
    fun `invalid | invalid slug`(slug : String) = assertInvalid(slug)

    @Test
    fun `invalid | extreme length`() = assertInvalid("a-a".repeat(100000))

    @Test
    fun `equal slug`() = assertTrue(Slug("a-slug") == Slug("a-slug"))

    @Test
    fun `string slug`() = assertEquals("a-slug", "${Slug("a-slug")}")

}