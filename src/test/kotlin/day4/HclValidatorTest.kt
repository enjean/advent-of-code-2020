package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HclValidatorTest {
    @Test
    fun `matches spec`() {
        assertTrue(HclValidator.validate(passportWithHcl("#123abc")))
    }

    @Test
    fun `letter outside range`() {
        assertFalse(HclValidator.validate(passportWithHcl("#123abz")))
    }

    @Test
    fun `missing leading #`() {
        assertFalse(HclValidator.validate(passportWithHcl("123abc")))
    }

    private fun passportWithHcl(hcl: String): Map<String, String> =
        mapOf("hcl" to hcl)
}