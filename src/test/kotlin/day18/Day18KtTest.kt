package day18

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day18KtTest {
    @Test
    fun `Example 1`() {
        assertEquals(71, evaluateExpression("1 + 2 * 3 + 4 * 5 + 6"))
    }

    @Test
    fun `Example 2`() {
        assertEquals(51, evaluateExpression("1 + (2 * 3) + (4 * (5 + 6))"))
    }

    @Test
    fun `Example 3`() {
        assertEquals(26, evaluateExpression("2 * 3 + (4 * 5)"))
    }

    @Test
    fun `Example 4`() {
        assertEquals(437, evaluateExpression("5 + (8 * 3 + 9 + 3 * 4 * 3)"))
    }

    @Test
    fun `Example 5`() {
        assertEquals(12240, evaluateExpression("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"))
    }

    @Test
    fun `Example 6`() {
        assertEquals(13632, evaluateExpression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"))
    }
}