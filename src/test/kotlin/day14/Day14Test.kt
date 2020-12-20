package day14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day14Test {

    @Test
    fun `Part 1 Example`() {
        val result = runProgramV1(listOf(
            "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
            "mem[8] = 11",
            "mem[7] = 101",
            "mem[8] = 0"
        ))
        //only two values in memory are not zero - 101 (at address 7) and 64 (at address 8) - producing a sum of 165.
        assertEquals(101, result[7])
        assertEquals(64, result[8])
        assertEquals(165, result.values.sum())
    }

    @Test
    fun `Part 2 Example`() {
        val result = runProgramV2(listOf(
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1"
        ))
        assertEquals(208, result.values.sum())
    }
}