package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HgtValidatorTest {
    @Test
    fun `Valid in`() {
        assertTrue(HgtValidator.validate(passportWithHgt("60in")))
    }

    @Test
    fun `Valid cm`() {
        assertTrue(HgtValidator.validate(passportWithHgt("190cm")))
    }
    @Test
    fun `Invalid in`() {
        assertFalse(HgtValidator.validate(passportWithHgt("190in")))
    }

    @Test
    fun `Missing units`() {
        assertFalse(HgtValidator.validate(passportWithHgt("190")))
    }

    private fun passportWithHgt(hgt: String): Map<String, String> =
        mapOf("hgt" to hgt)
}