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

fun parse(input: List<String>): List<Instruction> =
    input.map { line ->
        val splitLine = line.split(" ")
        Instruction(Operation.valueOf(splitLine[0].toUpperCase()), splitLine[1].toInt())
    }

fun execute(instruction: Instruction, programState: ProgramState): ProgramState =
    when (instruction.operation) {
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

fun findFix(program: List<Instruction>): ProgramState {
    program.indices.forEach { index ->
        val updatedProgram = swapInstructionInProgram(program, index)
        val resultWithUpdateProgram = runUntilRepeatOrTerminate(updatedProgram)
        if (resultWithUpdateProgram.instructionPointer >= program.size) return resultWithUpdateProgram
    }
    throw IllegalStateException("Didn't find instruction to swap")
}

private fun swapInstructionInProgram(program: List<Instruction>, instruction: Int): List<Instruction> =
    program.mapIndexed { index, existing ->
        if (index == instruction) swap(existing) else existing
    }

private fun swap(instruction: Instruction): Instruction =
    when (instruction.operation) {
        Operation.ACC -> instruction
        Operation.JMP -> Instruction(operation = Operation.NOP, instruction.argument)
        Operation.NOP -> Instruction(operation = Operation.JMP, instruction.argument)
    }

fun runUntilRepeatOrTerminate(program: List<Instruction>): ProgramState =
    runStep(program, ProgramState(instructionPointer = 0, accumulator = 0), emptySet())

private fun runStep(program: List<Instruction>, programState: ProgramState, instructionsRun: Set<Int>): ProgramState =
    if (instructionsRun.contains(programState.instructionPointer) || programState.instructionPointer >= program.size) {
        programState
    } else {
        val newState = execute(program[programState.instructionPointer], programState)
        runStep(program, newState, instructionsRun + programState.instructionPointer)
    }

fun main() {
    val program = parse(ParseUtil.inputLines(8))

    val stateAtRepeat = runUntilRepeatOrTerminate(program)
    println("Part 1 = ${stateAtRepeat.accumulator}")

    val stateWhenFixed = findFix(program)
    println("Part 2 = ${stateWhenFixed.accumulator}")
}