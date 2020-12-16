package day11

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day11Test {
    private val exampleInput = listOf(
        "L.LL.LL.LL",
        "LLLLLLL.LL",
        "L.L.L..L..",
        "LLLL.LL.LL",
        "L.LL.LL.LL",
        "L.LLLLL.LL",
        "..L.L.....",
        "LLLLLLLLLL",
        "L.LLLLLL.L",
        "L.LLLLL.LL"
    )

    @Nested
    inner class PartOne {
        @Test
        fun `In first step, all seats are taken`() {
            val result = applyPart1SeatingRules(parseSeatModel(exampleInput))
            assertEquals(71, result.first.numOccupied())
            assertEquals(71, result.second)
        }

        @Test
        fun `After a second round, the seats with four or more occupied adjacent seats become empty again`() {
            val stepOneResult = applyPart1SeatingRules(parseSeatModel(exampleInput))
            val stepTwoResult = applyPart1SeatingRules(stepOneResult.first)
            assertEquals(20, stepTwoResult.first.numOccupied())
            assertEquals(51, stepTwoResult.second)
        }

        @Test
        fun `apply model until no changes`() {
            val result = modelUntilStatic(parseSeatModel(exampleInput), ::applyPart1SeatingRules)
            assertEquals(37, result.numOccupied())
        }
    }

    @Nested
    inner class PartTwo {
        @Test
        fun `apply model until no changes`() {
            val result = modelUntilStatic(parseSeatModel(exampleInput), ::applyPart2SeatingRules)
            assertEquals(26, result.numOccupied())
        }
    }
}