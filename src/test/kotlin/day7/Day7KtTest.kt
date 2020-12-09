package day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

class Day7KtTest {

    @Nested
    inner class ParseRule {
        @Test
        fun `Can hold 2 other`() {
            val input = "light red bags contain 1 bright white bag, 2 muted yellow bags."
            assertEquals(Pair("light red", setOf(Pair("bright white", 1), Pair("muted yellow", 2))), parseRule(input))
        }

        @Test
        fun `Can hold 1 other`() {
            val input = "bright white bags contain 1 shiny gold bag."
            assertEquals(Pair("bright white", setOf(Pair("shiny gold", 1))), parseRule(input))
        }

        @Test
        fun `Can hold none`() {
            val input = "faded blue bags contain no other bags."
            assertEquals(Pair("faded blue", emptySet<Pair<String, Int>>()), parseRule(input))
        }
    }

    val example1Input = listOf(
        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
        "bright white bags contain 1 shiny gold bag.",
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
        "faded blue bags contain no other bags.",
        "dotted black bags contain no other bags."
    )

    @Test
    fun `Part 1 Example`() {
        assertEquals(4, bagsThatCanHold(example1Input))
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Example 1`() {
            assertEquals(32, numberOfBagsContained(example1Input, "shiny gold"))
        }

        @Test
        fun `Example 2`() {
            val input = listOf(
                "shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.",
                "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.",
                "dark violet bags contain no other bags."
            )
            assertEquals(126, numberOfBagsContained(input, "shiny gold"))
        }
    }
}