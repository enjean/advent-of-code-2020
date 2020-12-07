package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PidValidatorTest {
    @Test
    fun `9 Digit Number`() {
        assertTrue(PidValidator.validate(passportWithPid("000000001")))
    }

    @Test
    fun `10 Digit Number`() {
        assertFalse(PidValidator.validate(passportWithPid("0123456789")))
    }

    private fun passportWithPid(pid: String): Map<String, String> =
        mapOf("pid" to pid)
}