package day12

import util.ParseUtil

fun parseInstructions(lines: List<String>): List<Instruction> =
    lines.map { line ->
        val action = when(line[0]) {
            'N' -> Action.NORTH
            'S' -> Action.SOUTH
            'E' -> Action.EAST
            'W' -> Action.WEST
            'L' -> Action.LEFT
            'R' -> Action.RIGHT
            'F' -> Action.FORWARD
            else -> throw IllegalArgumentException("Unable to parse action from $line")
        }
        val value = line.substring(1).toInt()
        Instruction(action, value)
    }

fun processInstructions(instructions: List<Instruction>): ShipState =
    instructions.fold(ShipState(0, 0, Direction.EAST), ::processInstruction)

fun processInstruction(shipState: ShipState, instruction: Instruction): ShipState =
    when(instruction.action) {
        Action.NORTH -> shipState.north(instruction.value)
        Action.SOUTH -> shipState.south(instruction.value)
        Action.EAST -> shipState.east(instruction.value)
        Action.WEST -> shipState.west(instruction.value)
        Action.LEFT -> shipState.left(instruction.value)
        Action.RIGHT -> shipState.right(instruction.value)
        Action.FORWARD -> shipState.forward(instruction.value)
    }


fun main() {
    val instructions = parseInstructions(ParseUtil.inputLines(12))

    val stateAfterInstructions = processInstructions(instructions)
    println("Part 1 = ${stateAfterInstructions.manhattanDistanceFromOrigin}")
}