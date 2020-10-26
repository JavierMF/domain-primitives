package org.javiermf.primitives.auth

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SHA1HashTests {
    private fun assertValid(hashHex: String) = Assertions.assertNotNull(SHA1Hash(hashHex))
    private fun assertInvalid(hashHex: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { SHA1Hash(hashHex) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "62E247FE88240FA9848FD09846162FCE395B018A",
        "62e247fE88240Fa9848FD09846162FcE395b018a",
        "25BA3E51F5F391836288BBD426964A9C2A4951DF",
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaA"
    ])
    fun `valid | valid hash`(hashHex : String) = assertValid(hashHex)

    @ParameterizedTest
    @ValueSource(strings = [
        "",
        " ",
        "a",
        "62E247FE88240FA9848FD09846162FCE395B018Aa",
        "_2E247FE88240FA9848FD09846162FCE395B018A"
    ])
    fun `invalid | invalid hashHex`(hashHex : String) = assertInvalid(hashHex)

    @Test
    fun `invalid | extreme length`() = assertInvalid("aa".repeat(100000))

    @Test
    fun `equal hash`() = Assertions.assertTrue(SHA1Hash("62E247FE88240FA9848FD09846162FCE395B018A") == SHA1Hash("62e247fE88240Fa9848FD09846162FcE395b018a"))

    @Test
    fun `equal byteArray`() = Assertions.assertTrue(SHA1Hash("62E247FE88240FA9848FD09846162FCE395B018A").byteArray.contentEquals(SHA1Hash("62e247fE88240Fa9848FD09846162FcE395b018a").byteArray))

    @Test
    fun `string hash`() = Assertions.assertEquals("62e247fe88240fa9848fd09846162fce395b018a", "${SHA1Hash("62e247fE88240Fa9848FD09846162FcE395b018a")}")
}