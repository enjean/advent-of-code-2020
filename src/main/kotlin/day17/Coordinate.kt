package day17

data class Coordinate(
    val x: Int,
    val y: Int,
    val z: Int
) {
    val neighbors: Set<Coordinate>
        get() =
            (-1..1).flatMap { dx ->
                (-1..1).flatMap { dy ->
                    (-1..1).mapNotNull { dz ->
                        if (dx == 0 && dy == 0 && dz == 0) {
                            null
                        } else {
                            Coordinate(x = x + dx, y = y + dy, z = z + dz)
                        }
                    }
                }
            }.toSet()

}