package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EclValidatorTest {
    @Test
    fun `one of valid values`() {
        assertTrue(EclValidator.validate(passportWithEcl("brn")))
    }

    @Test
    fun `not one of valid values`() {
        assertFalse(EclValidator.validate(passportWithEcl("wat")))
    }

    private fun passportWithEcl(ecl: String): Map<String, String> =
        mapOf("ecl" to ecl)
}