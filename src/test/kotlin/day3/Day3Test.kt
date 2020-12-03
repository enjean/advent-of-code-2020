package day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day3Test {
    @Nested
    inner class Part1 {
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

        @Test
        fun `Right 1, down 1`() {
            assertEquals(2, traverseForest(forestLines, 1, 1))
        }

        @Test
        fun `Right 3, down 1`() {
            assertEquals(7, traverseForest(forestLines, 3, 1))
        }

        @Test
        fun `Right 5, down 1`() {
            assertEquals(3, traverseForest(forestLines, 5, 1))
        }

        @Test
        fun `Right 7, down 1`() {
            assertEquals(4, traverseForest(forestLines, 7, 1))
        }

        @Test
        fun `Right 1, down 2`() {
            assertEquals(2, traverseForest(forestLines, 1, 2))
        }
    }
}