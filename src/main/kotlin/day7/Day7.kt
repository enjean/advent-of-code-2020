package day7

import util.ParseUtil

private val lineRegex = """^(.+) bags contain (.+)\.${'$'}""".toRegex()
private val childRegex = """^(\d+) (.+) bag[s]?$""".toRegex()

data class BagItem(
    val bagName: String,
    val count: Int
)

data class BagRule(
    val bagName: String,
    val contents: Set<BagItem>
)

fun parseRule(rule: String): BagRule =
    lineRegex.matchEntire(rule)?.let { matchResult ->
        BagRule(
            bagName = matchResult.groupValues[1],
            contents = parseRHS(matchResult.groupValues[2])
        )
    } ?: throw IllegalArgumentException("Unable to match $rule")

private fun parseRHS(rhs: String): Set<BagItem> =
    if (rhs == "no other bags") {
        emptySet()
    } else {
        rhs.split(", ")
            .map { childLine ->
                childRegex.matchEntire(childLine)?.let { childMatch ->
                    BagItem(
                        bagName = childMatch.groupValues[2],
                        count = childMatch.groupValues[1].toInt()
                    )
                } ?: throw IllegalArgumentException("Unable to match child $childLine")
            }.toSet()
    }

fun bagsThatCanHold(bagRules: List<String>, bagName: String): Int {
    val rules = bagRules.map { parseRule(it) }
    val parentMap = rules.fold(emptyMap<String, Set<String>>()) { parentMapAccum, rule ->
        updateMapForRule(parentMapAccum, rule)
    }
    return ancestorsOf(parentMap, bagName, emptySet()).size
}

private fun updateMapForRule(parentMap: Map<String, Set<String>>, bagRule: BagRule) : Map<String, Set<String>> =
    bagRule.contents.fold(parentMap) { parentMapAccum, bagItem ->
        val currentParentsOfItem = parentMapAccum[bagItem.bagName] ?: emptySet()
        parentMapAccum + (bagItem.bagName to (currentParentsOfItem + bagRule.bagName))
    }

private fun ancestorsOf(bagParents: Map<String, Set<String>>, bag: String, ancestorsSoFar: Set<String>): Set<String> =
    (bagParents[bag] ?: emptySet()).fold(ancestorsSoFar) { ancestors, parent ->
        if (ancestors.contains(parent)) {
            ancestors
        } else {
            ancestorsOf(bagParents, parent, ancestors + parent)
        }
    }

fun numberOfBagsContained(bagRules: List<String>, bag: String): Int {
    val rules = bagRules.map { parseRule(it) }
        .map { it.bagName to it.contents }
        .toMap()
    return numberOfBagsContained(rules, bag)
}

private fun numberOfBagsContained(bagsInBag: Map<String, Set<BagItem>>, bag: String): Int =
    bagsInBag[bag]?.let { bagItems ->
        bagItems.sumOf {
            it.count + it.count * numberOfBagsContained(bagsInBag, it.bagName)
        }
    } ?: throw IllegalArgumentException("No rules for $bag")

fun main() {
    val input = ParseUtil.inputLines(7)

    println("Part 1 = ${bagsThatCanHold(input, "shiny gold")}")
    println("Part 2 = ${numberOfBagsContained(input, "shiny gold")}")
}