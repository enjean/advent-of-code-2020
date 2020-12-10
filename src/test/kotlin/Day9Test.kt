import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day9Test {
    private val input = listOf<Long>(
        35,
        20,
        15,
        25,
        47,
        40,
        62,
        55,
        65,
        95,
        102,
        117,
        150,
        182,
        127,
        219,
        299,
        277,
        309,
        576
    )

    @Test
    fun `Find Invalid`() {
        assertEquals(127, findInvalid(input, 5))
    }

    @Test
    fun `Find range adding to`() {
        assertEquals(Pair<Long, Long>(15, 47), findRangeAddingTo(input, 127))
    }
}