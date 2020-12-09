package day8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day8Test {
    @Test
    fun `Run until repeat example`() {
        val program = parse(
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
        val resultState = runUntilRepeat(program)
        assertEquals(5, resultState.accumulator)
    }
}