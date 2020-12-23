package day15

data class GameState(
    val spoken: Long,
    val turnNumber: Long,
    val turnLastSpoken: Map<Long, Long>
)

fun playGame(startingNumbers: List<Long>, turnToStop: Long): Long =
    numberSpoken(initializeGameState(startingNumbers), turnToStop)

private tailrec fun numberSpoken(gameState: GameState, turnToStop: Long): Long =
    if (gameState.turnNumber == turnToStop) {
        gameState.spoken
    } else {
        numberSpoken(takeTurn(gameState), turnToStop)
    }

private fun initializeGameState(startingNumbers: List<Long>): GameState {
    val turnLastSpoken = (0 until startingNumbers.size - 1).map { index ->
        startingNumbers[index] to index.toLong() + 1
    }.toMap()
    return GameState(
        spoken = startingNumbers.last(),
        turnNumber = startingNumbers.size.toLong(),
        turnLastSpoken = turnLastSpoken
    )
}

fun playGameMutable(startingNumbers: List<Long>, turnToStop: Long): Long {
    val turnLastSpoken = (0 until startingNumbers.size - 1).map { index ->
        startingNumbers[index] to index.toLong() + 1
    }.toMap().toMutableMap()

    var spokenLastTurn = startingNumbers.last()
    var turnNumber = startingNumbers.size.toLong() + 1

    while (turnNumber <= turnToStop) {
        val lastTurnNumber = turnNumber - 1
        val valueToSpeak = turnLastSpoken[spokenLastTurn]?.let { lastTurnNumber - it } ?: 0
        turnLastSpoken[spokenLastTurn] = lastTurnNumber

        spokenLastTurn = valueToSpeak
        turnNumber++
    }
    return spokenLastTurn
}

private fun takeTurn(gameState: GameState): GameState {
    if (gameState.turnNumber % 10000 == 0.toLong()) {
        println("Turn=${gameState.turnNumber} Value=${gameState.spoken}")
    }
    val valueToSpeak = gameState.turnLastSpoken[gameState.spoken]?.let { gameState.turnNumber - it } ?: 0
    return GameState(
        spoken = valueToSpeak,
        turnNumber = gameState.turnNumber + 1,
        turnLastSpoken = gameState.turnLastSpoken + (gameState.spoken to gameState.turnNumber)
    )
}

fun main() {
    val input = listOf(2, 20, 0, 4, 1, 17).map { it.toLong() }

    println("Part 1 = ${playGame(input, 2020)}")
    println("Part 2 = ${playGameMutable(input, 30000000)}")
}