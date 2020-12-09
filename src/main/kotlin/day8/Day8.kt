package day8

import util.ParseUtil

enum class Operation {
    ACC, JMP, NOP
}

data class Instruction(
    val operation: Operation,
    val argument: Int
)

data class ProgramState(
    val instructionPointer: Int,
    val accumulator: Int
)

fun parse(input: List<String>) : List<Instruction> =
    input.map { line ->
        val splitLine = line.split(" ")
        Instruction(Operation.valueOf(splitLine[0].toUpperCase()), splitLine[1].toInt())
    }

fun execute(instruction: Instruction, programState: ProgramState): ProgramState =
    when(instruction.operation) {
        Operation.ACC -> ProgramState(
            instructionPointer = programState.instructionPointer + 1,
            accumulator = programState.accumulator + instruction.argument
        )
        Operation.JMP -> ProgramState(
            instructionPointer = programState.instructionPointer + instruction.argument,
            accumulator = programState.accumulator
        )
        Operation.NOP -> ProgramState(
            instructionPointer = programState.instructionPointer + 1,
            accumulator = programState.accumulator
        )
    }

fun runUntilRepeat(program: List<Instruction>) : ProgramState =
    runStep(program, ProgramState(instructionPointer = 0, accumulator = 0), emptySet())

private fun runStep(program: List<Instruction>, programState: ProgramState, instructionsRun:Set<Int>) : ProgramState =
    if (instructionsRun.contains(programState.instructionPointer)) {
        programState
    } else {
        val newState = execute(program[programState.instructionPointer], programState)
        runStep(program, newState, instructionsRun + programState.instructionPointer)
    }

fun main() {
    val program = parse(ParseUtil.inputLines(8))

    val stateAtRepeat = runUntilRepeat(program)
    println("Part 1 = ${stateAtRepeat.accumulator}")
}