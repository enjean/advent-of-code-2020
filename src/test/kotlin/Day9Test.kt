import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day9Test {
    @Test
    fun `Find Invalid`() {
        val input = listOf<Long>(
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
        assertEquals(127, findInvalid(input, 5))
    }
}