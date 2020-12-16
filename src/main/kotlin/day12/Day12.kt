package day12

import util.ParseUtil

fun parseInstructions(lines: List<String>): List<Instruction> =
    lines.map { line ->
        val action = when (line[0]) {
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

val initialShipState1 = ShipState1(
    shipCoordinate = Coordinate(0, 0),
    direction = Direction.EAST
)

val initialShipState2 = ShipState2(
    shipCoordinate = Coordinate(0, 0),
    waypointCoordinate = Coordinate(10, 1)
)

fun processInstructions(instructions: List<Instruction>, initialShipState: ShipState): ShipState =
    instructions.fold(initialShipState, ::processInstruction)

fun processInstruction(shipState: ShipState, instruction: Instruction): ShipState =
    when (instruction.action) {
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

    val state1AfterInstructions = processInstructions(instructions, initialShipState1)
    println("Part 1 = ${state1AfterInstructions.shipCoordinate.manhattanDistanceFromOrigin}")

    val state2AfterInstructions = processInstructions(instructions, initialShipState2)
    println("Part 2 = ${state2AfterInstructions.shipCoordinate.manhattanDistanceFromOrigin}")
}