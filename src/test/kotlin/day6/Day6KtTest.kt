package day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import util.ParseUtil

class Day6KtTest {
    @Nested
    inner class UniqueQuestions {
        @Test
        fun `Example 1`() {
            assertEquals(
                6, uniqueQuestions(
                    listOf(
                        "abcx",
                        "abcy",
                        "abcz"
                    )
                )
            )
        }

        @Test
        fun `Example 2`() {
            assertEquals(
                3, uniqueQuestions(
                    listOf(
                        "abc"
                    )
                )
            )
        }

        @Test
        fun `Example 3`() {
            assertEquals(
                3, uniqueQuestions(
                    listOf(
                        "a",
                        "b",
                        "c"
                    )
                )
            )
        }

        @Test
        fun `Example 4`() {
            assertEquals(
                3, uniqueQuestions(
                    listOf(
                        "ab",
                        "ac"
                    )
                )
            )
        }

        @Test
        fun `Example 5`() {
            assertEquals(
                1, uniqueQuestions(
                    listOf(
                        "a",
                        "a",
                        "a",
                        "a"
                    )
                )
            )
        }

        @Test
        fun `Example 6`() {
            assertEquals(
                1, uniqueQuestions(
                    listOf(
                        "b"
                    )
                )
            )
        }

        @Test
        fun `Total Unique Questions`() {
            val input = listOf(
                "abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b"
            )
            assertEquals(11, totalUniqueQuestions(ParseUtil.parseGroups(input)))
        }
    }

    @Nested
    inner class AllAnsweredYes {
        @Test
        fun `Example 1`() {
            assertEquals(
                3, allAnsweredYes(
                    listOf(
                        "abcx",
                        "abcy",
                        "abcz"
                    )
                )
            )
        }

        @Test
        fun `Example 2`() {
            assertEquals(
                3, allAnsweredYes(
                    listOf(
                        "abc"
                    )
                )
            )
        }

        @Test
        fun `Example 3`() {
            assertEquals(
                0, allAnsweredYes(
                    listOf(
                        "a",
                        "b",
                        "c"
                    )
                )
            )
        }

        @Test
        fun `Example 4`() {
            assertEquals(
                1, allAnsweredYes(
                    listOf(
                        "ab",
                        "ac"
                    )
                )
            )
        }

        @Test
        fun `Example 5`() {
            assertEquals(
                1, allAnsweredYes(
                    listOf(
                        "a",
                        "a",
                        "a",
                        "a"
                    )
                )
            )
        }

        @Test
        fun `Example 6`() {
            assertEquals(
                1, allAnsweredYes(
                    listOf(
                        "b"
                    )
                )
            )
        }

        @Test
        fun `Total Unique Questions`() {
            val input = listOf(
                "abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b"
            )
            assertEquals(6, totalAllAnswered(ParseUtil.parseGroups(input)))
        }

    }

}