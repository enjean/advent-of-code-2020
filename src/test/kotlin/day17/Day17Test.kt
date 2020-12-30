package day17

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day17Test {
    private val exampleInput = listOf(
        ".#.",
        "..#",
        "###"
    )

    @Test
    fun `Example - First Cycle`() {
        val after1 = performCycle(parseModel(exampleInput, 3))
        assertEquals(11, after1.size)
    }

    @Test
    fun `Simulate - 3D`() {
        val result = runSimulation(parseModel(exampleInput, 3), 6)
        assertEquals(112, result.size)
    }

    @Test
    fun `Simulate - 4D`() {
        val result = runSimulation(parseModel(exampleInput, 4), 6)
        assertEquals(848, result.size)
    }
}