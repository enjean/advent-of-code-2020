package day17

data class Coordinate(
    val values: List<Int>
) {
    val neighbors: Set<Coordinate>
        get() =
            deltas().map { deltaList ->
                Coordinate(deltaList.mapIndexed { index, delta -> values[index] + delta })
            }.toSet()

    private fun deltas() =
        deltas(values.size).filterNot { it.all { delta -> delta == 0 } }

    private fun deltas(dimension: Int) : List<List<Int>> =
        if(dimension == 0) {
            listOf(
                emptyList()
            )
        } else {
            deltas(dimension - 1).flatMap { lowerDelta ->
                listOf(
                    lowerDelta + -1,
                    lowerDelta + 0,
                    lowerDelta + 1
                )
            }
        }
}