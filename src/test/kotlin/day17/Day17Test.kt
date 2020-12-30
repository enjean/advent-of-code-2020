package day17

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day17Test {
    private val exampleInitialState = parseModel(
        listOf(
            ".#.",
            "..#",
            "###"
        )
    )

    @Nested
    inner class PerformCycle {
        @Test
        fun `Example - First Cycle`() {

            val after1 = performCycle(exampleInitialState)

            assertEquals(11, after1.size)
        }

    }

    @Test
    fun `Part 1 Example`() {
        val result = runSimulation(exampleInitialState, 6)
        assertEquals(112, result.size)
    }
}