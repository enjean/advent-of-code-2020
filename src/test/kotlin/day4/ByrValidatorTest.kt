package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ByrValidatorTest {

    @Test
    fun `In Valid Range`() {
        assertTrue(ByrValidator.validate(passportWithByr("2002")))
    }

    @Test
    fun `At most 2002`() {
        assertFalse(ByrValidator.validate(passportWithByr("2003")))
    }

    private fun passportWithByr(byr: String): Map<String, String> =
        mapOf("byr" to byr)
}