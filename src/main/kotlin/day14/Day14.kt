package day14

import util.ParseUtil

private val maskRegex = """^mask = ([X01]+)$""".toRegex()
private val memoryRegex = """^mem\[(\d+)] = (\d+)$""".toRegex()

data class ProgramState(
    val currentMasker: Bitmasker,
    val memory: Map<Long, Long>
)

fun runProgram(lines: List<String>): Map<Long, Long> {
    val masker = parseMaskLine(lines[0])
    return lines.subList(1, lines.size)
        .fold(ProgramState(masker, emptyMap())) { programState, line ->
            if (maskRegex.matches(line)) {
                programState.copy(currentMasker = parseMaskLine(line))
            } else {
                val instruction = parseMemoryLine(line)
                val valueToSet = programState.currentMasker.mask(instruction.value)
                programState.copy(memory = programState.memory + (instruction.memoryAddress to valueToSet))
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

fun main() {
    val program = ParseUtil.inputLines(14)
    val memory = runProgram(program)
    println("Part 1 = ${memory.values.sum()}")
}