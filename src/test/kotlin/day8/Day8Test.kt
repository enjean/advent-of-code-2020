package day8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day8Test {
    private val program = parse(
        listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
        )
    )

    @Test
    fun `Run until repeat example`() {
        val resultState = runUntilRepeatOrTerminate(program)
        assertEquals(5, resultState.accumulator)
    }

    @Test
    fun `Part 2`() {
        val resultState = findFix(program)
        assertEquals(8, resultState.accumulator)
    }
}