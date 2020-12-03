package day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day3Test {
    @Nested
    inner class Part1 {
        @Test
        fun `Part 1 Example`() {
            val forestLines = listOf(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
            )
            assertEquals(7, traverseForest(forestLines))
        }
    }
}