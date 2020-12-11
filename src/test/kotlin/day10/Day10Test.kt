package day10

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day10Test {
    private val smallInput = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)
    val largeInput = listOf(
        28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49,
        45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3
    )

    @Nested
    inner class DifferencesWhenConnected {
        @Test
        fun `small example`() {
            val result = differencesWhenConnected(smallInput)
            assertEquals(7, result[1])
            assertEquals(5, result[3])
        }

        @Test
        fun `large example`() {

            val result = differencesWhenConnected(largeInput)
            assertEquals(22, result[1])
            assertEquals(10, result[3])
        }
    }

    @Nested
    inner class PossibleCombinations {
        @Test
        fun `small example`() {
            assertEquals(8, possibleCombinations(smallInput))
        }

        @Test
        fun `large example`() {
            assertEquals(19208, possibleCombinations(largeInput))
        }
    }
}