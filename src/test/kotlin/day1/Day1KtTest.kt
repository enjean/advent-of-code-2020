package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Tests {
    @Test
    fun `Part 1`() {
        val input = listOf(
            1721,
            979,
            366,
            299,
            675,
            1456
        )
        val result = find2NumbersThatSum(input)
        assertEquals(1721 to 299, result)
    }

    @Test
    fun `Part 2`() {
        val input = listOf(
            1721,
            979,
            366,
            299,
            675,
            1456
        )
        val result = find3NumbersThatSum(input)
        assertEquals(Triple(979,366,675), result)
    }
}