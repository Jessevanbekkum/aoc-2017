package day24

import util.readLines

fun strongest(input: String): Int {

    val parts = readLines(input).sorted()
            .map { s -> s.split("/") }
            .map { s -> s.sorted() }
            .map { s -> Pair(s[0].toInt(), s[1].toInt()) }


    return sum(buildStrongestBridge(parts, 0, emptyList()))
}

fun longest(input: String): Int {

    val parts = readLines(input).sorted()
            .map { s -> s.split("/") }
            .map { s -> s.sorted() }
            .map { s -> Pair(s[0].toInt(), s[1].toInt()) }


    return sum(buildLongestBridge(parts, 0, emptyList()))
}


fun findMatchingPieces(blocks: List<Pair<Int, Int>>, pins: Int): List<Pair<Int, Int>> {
    return blocks.filter { p -> p.first == pins || p.second == pins }
}

fun buildStrongestBridge(blocks: List<Pair<Int, Int>>, pins: Int, path: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
    val next = findMatchingPieces(blocks, pins)

    if (next.isEmpty()) {
        return path;
    } else {
        val options = next.map {
            val nextPin = if (it.first == pins) it.second else it.first
            buildLongestBridge(blocks.minus(it), nextPin, path + it)
        }
        return options.map { p -> Pair(p, sum(p)) }.maxBy { p -> p.second }?.first!!
    }


}

fun buildLongestBridge(blocks: List<Pair<Int, Int>>, pins: Int, path: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
    val next = findMatchingPieces(blocks, pins)

    if (next.isEmpty()) {
        return path;
    } else {
        val options = next.map {
            val nextPin = if (it.first == pins) it.second else it.first
            buildLongestBridge(blocks.minus(it), nextPin, path + it)
        }
        val max = options.map { p -> p.size}.max()

        return options.filter { p -> p.size == max }.map { p -> Pair(p, sum(p)) }.maxBy { p -> p.second }?.first!!
    }


}

fun sum(path: List<Pair<Int, Int>>): Int {
    return path.map { p -> p.first + p.second }.sum()
}