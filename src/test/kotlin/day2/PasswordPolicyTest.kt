package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PasswordPolicyTest {
    @Nested
    inner class MeetsPolicy {
        @Test
        fun `Example 1`() {
            assertTrue(PasswordPolicy('a', 1, 3).meetsPolicy("abcde"))
        }
        @Test
        fun `Example 2`() {
            assertFalse(PasswordPolicy('b', 1, 3).meetsPolicy("cdefg"))
        }
        @Test
        fun `Example 3`() {
            assertTrue(PasswordPolicy('c', 2, 9).meetsPolicy("ccccccccc"))
        }
    }
}