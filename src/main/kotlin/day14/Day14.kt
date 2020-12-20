package day14

import util.ParseUtil

private val maskRegex = """^mask = ([X01]+)$""".toRegex()
private val memoryRegex = """^mem\[(\d+)] = (\d+)$""".toRegex()

data class ProgramState(
    val currentMasker: Bitmasker,
    val memory: Map<Long, Long>
)

fun runProgramV1(lines: List<String>): Map<Long, Long> =
    runProgram(lines, ::executeInstructionV1)

fun runProgramV2(lines: List<String>): Map<Long, Long> =
    runProgram(lines, ::executeInstructionV2)

private fun runProgram(lines: List<String>, instructionExecutor: (Instruction, ProgramState) -> ProgramState): Map<Long, Long> {
    val masker = parseMaskLine(lines[0])
    return lines.subList(1, lines.size)
        .fold(ProgramState(masker, emptyMap())) { programState, line ->
            if (maskRegex.matches(line)) {
                programState.copy(currentMasker = parseMaskLine(line))
            } else {
                val instruction = parseMemoryLine(line)
                instructionExecutor.invoke(instruction, programState)
            }
        }.memory
}

private fun parseMaskLine(line: String): Bitmasker =
    maskRegex.matchEntire(line)?.groupValues?.get(1)?.let { Bitmasker(it) }
        ?: throw IllegalArgumentException("Unable to parse mask from \"$line\"")

private fun parseMemoryLine(line: String): Instruction =
    memoryRegex.matchEntire(line)?.let { match ->
        Instruction(match.groupValues[1].toLong(), match.groupValues[2].toLong())
    }?: throw IllegalArgumentException("Unable to parse memory line")

fun executeInstructionV1(instruction: Instruction, programState: ProgramState): ProgramState {
    val valueToSet = programState.currentMasker.mask(instruction.value)
    return programState.copy(memory = programState.memory + (instruction.memoryAddress to valueToSet))
}

fun executeInstructionV2(instruction: Instruction, programState: ProgramState): ProgramState {
    println("Executing $instruction")
    val memoryAddresses = programState.currentMasker.decodeMemoryAddress(instruction.memoryAddress)
    return memoryAddresses.fold(programState) { currentState, memoryAddress ->
        currentState.copy(memory = currentState.memory + (memoryAddress to instruction.value))
    }
}

fun main() {
    val program = ParseUtil.inputLines(14)
    val memoryV1 = runProgramV1(program)
    println("Part 1 = ${memoryV1.values.sum()}")

    println("Part 2 = ${runProgramV2(program).values.sum()}")
}