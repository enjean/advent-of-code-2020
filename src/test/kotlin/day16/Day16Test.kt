package day16

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day16Test {
    @Test
    fun `Invalid Values`() {
        val input = parseInput(
            listOf(
                "class: 1-3 or 5-7",
                "row: 6-11 or 33-44",
                "seat: 13-40 or 45-50",
                "",
                "your ticket:",
                "7,1,14",
                "",
                "nearby tickets:",
                "7,3,47",
                "40,4,50",
                "55,2,20",
                "38,6,12"
            )
        )
        assertEquals(listOf(4, 55 ,12), invalidValues(input))
    }
}