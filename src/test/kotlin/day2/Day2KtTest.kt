package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2KtTest {
    @Test
    fun `Can parse`() {
        assertEquals(Pair(PasswordPolicy('a', 1, 3), "abcde"), parse("1-3 a: abcde"))
    }
}