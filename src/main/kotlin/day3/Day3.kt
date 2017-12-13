package day3

import java.lang.Math.abs
import java.lang.Math.sqrt

fun ringSize(ring: Int): Int {
    if (ring == 0) {
        return 1;
    }

    return ((ring - 1) * 2 + 1) * 4 + 4
}

fun middles(ring: Int): List<Int> {

    var diff = 2 * ring;
    val first = squareSize(ring - 1) + ring

    return listOf(first, first + diff, first + 2 * diff, first + 3 * diff)
}

fun squareSize(ring: Int): Int {
    return (ring * 2 + 1) * (ring * 2 + 1)
}

fun path(input: Int): Int {
    var i = myRing(input)
    return middles(i).map { v -> abs(input - v) }.min()!! + i
}

private fun myRing(input: Int): Int {
    var i = 0;
    while (squareSize(i) <= input) {
        i++;
    }
    return i
}

fun getCoordinates(input: Int): Pair<Int, Int> {
    val biggerSquare = (0..1000).map { i -> i * 2 + 1 }.map { i -> i * i }.first { sq -> sq >= input }

    val r = (sqrt(biggerSquare.toDouble()).toInt() - 1) / 2;
    var x: Int = r
    var y = -1 * x;
    var current = biggerSquare;
    while (current != input) {
        current--;
        if (y == -r && x==r) {
            x--;
            continue
        }
        if (x == r) {
            y--
            continue
        }
        if (y == r) {
            x++;
            continue
        }
        if (x == -r) {
            y++
            continue
        }
        if (y == -r) {
            x--;
            continue
        }
    }
    return Pair(x, y);
}


fun neighbours(input: Int): List<Pair<Int, Int>> {
    if (input == 0) {
        return emptyList()
    }

    val coor = getCoordinates(input);
return listOf(
        Pair(coor.first-1, coor.second),
        Pair(coor.first-1, coor.second-1),
        Pair(coor.first, coor.second-1),
        Pair(coor.first+1, coor.second-1),
        Pair(coor.first+1, coor.second),
        Pair(coor.first+1, coor.second+1),
        Pair(coor.first, coor.second+1),
        Pair(coor.first-1, coor.second+1)
)

}


fun firstLarger(input: Int) :Int {
    val grid = mutableMapOf< Pair<Int, Int>, Int>()

    (1..input).forEach { grid.put( getCoordinates(it), it) }

    val mem = mutableListOf<Int>(1)
    var i = 2;
    while (mem.last() < input) {
        val neigh = neighbours(i);
        val sum = neigh
                .map { s -> grid.get(s) }
                .filterNotNull()
                .map {j -> mem.getOrElse(j-1){0} }
                .sum()
        mem.add(sum)
        i++
    }

    return mem.last()
}