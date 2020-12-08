package day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5KtTest {
    @Test
    fun `Example 1`() {
        seatTest("FBFBBFFRLR", 44, 5, 357)
    }

    @Test
    fun `Example 2`() {
        seatTest("BFFFBBFRRR", 70, 7, 567)
    }

    @Test
    fun `Example 3`() {
        seatTest("FFFBBBFRRR", 14, 7, 119)
    }

    @Test
    fun `Example 4`() {
        seatTest("BBFFBBFRLL", 102, 4, 820)
    }

    private fun seatTest(seatSpec: String, row: Int, col: Int, seatID: Int) {
        val result = toSeat(seatSpec)
        assertEquals(row, result.row)
        assertEquals(col, result.col)
        assertEquals(seatID, result.seatID)
    }
}