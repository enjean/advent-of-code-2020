package day7

import util.ParseUtil

private val lineRegex = """^(.+) bags contain (.+)\.${'$'}""".toRegex()
private val childRegex = """^(\d+) (.+) bag[s]?$""".toRegex()

fun parseRule(rule: String): Pair<String, Set<Pair<String, Int>>> =
    lineRegex.matchEntire(rule)?.let { matchResult ->
        val parentBag = matchResult.groupValues[1]
        parentBag to parseRHS(matchResult.groupValues[2])
    } ?: throw IllegalArgumentException("Unable to match $rule")

private fun parseRHS(rhs: String): Set<Pair<String, Int>> =
    if (rhs == "no other bags") {
        emptySet()
    } else {
        rhs.split(", ")
            .map { childLine ->
                childRegex.matchEntire(childLine)?.let { childMatch ->
                    childMatch.groupValues[2] to childMatch.groupValues[1].toInt()
                } ?: throw IllegalArgumentException("Unable to match child $childLine")
            }.toSet()
    }

data class BagsCanBeHeldBy(
    val bagParents: Map<String, Set<String>> = emptyMap()
) {
    fun withBagHeldBy(bag: String, parentBag: String): BagsCanBeHeldBy =
        BagsCanBeHeldBy(bagParents + (bag to ((bagParents[bag] ?: emptySet()) + parentBag)))
}

fun bagsThatCanHold(bagRules: List<String>): Int {
    val rules = bagRules.map { parseRule(it) }
    val bagsCanBeHeldBy = rules.fold(BagsCanBeHeldBy()) { currentBagsCanBeHeldBy, rule ->
        rule.second.fold(currentBagsCanBeHeldBy) { currentBagsCanBeHeldBy2, bagBeingHeld ->
            currentBagsCanBeHeldBy2.withBagHeldBy(bagBeingHeld.first, rule.first)
        }
    }
     return ancestorsOf(bagsCanBeHeldBy.bagParents, "shiny gold", emptySet()).size
}

private fun ancestorsOf(bagParents: Map<String, Set<String>>, bag: String, ancestorsSoFar: Set<String>) : Set<String> =
    (bagParents[bag] ?: emptySet()).fold(ancestorsSoFar) { ancestors, parent ->
        if (ancestors.contains(parent)) {
            ancestors
        } else {
            ancestorsOf(bagParents, parent, ancestors + parent)
        }
    }

fun main() {
    val input = ParseUtil.inputLines(7)

    println("Part 1 = ${bagsThatCanHold(input)}")
}