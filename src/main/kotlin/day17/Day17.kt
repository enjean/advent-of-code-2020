package day17

import util.ParseUtil

fun parseModel(input: List<String>) : Set<Coordinate> =
    input.foldIndexed(emptySet()) { row, acc, line ->
        line.foldIndexed(acc) { col, innerAcc, character ->
            if (character == '#') {
                innerAcc + Coordinate(x = col, y = row, z = 0)
            } else {
                innerAcc
            }
        }
    }

fun performCycle(activeCells: Set<Coordinate>): Set<Coordinate> {
    val neighborCounts: Map<Coordinate, Int> = activeCells.fold(emptyMap()) { countsSoFar, activeCell ->
        activeCell.neighbors.fold(countsSoFar) { csf, neighbor ->
            val oldCount = csf[neighbor] ?: 0
            csf + (neighbor to (oldCount + 1))
        }
    }
    return neighborCounts.entries.fold(emptySet()) { newlyActive, neighborCountEntry ->
        val coordinate = neighborCountEntry.key
        val activeNeighbors = neighborCountEntry.value
        if ((activeCells.contains(coordinate) && activeNeighbors == 2) || (activeNeighbors == 3)) {
            newlyActive + coordinate
        } else {
            newlyActive
        }
    }
}

fun runSimulation(activeCells: Set<Coordinate>, cycles: Int): Set<Coordinate> =
    if (cycles == 0) {
        activeCells
    } else {
        val afterCycle = performCycle(activeCells)
        runSimulation(activeCells = afterCycle, cycles = cycles - 1)
    }

fun main() {
    val initialState = parseModel(ParseUtil.inputLines(17))

    val part1Result = runSimulation(initialState, 6)

    println("Part 1 = ${part1Result.size}")
}