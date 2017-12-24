package day19

import util.readLines

val n = Pair(0, -1)
val o = Pair(1, 0)
val w = Pair(-1, 0)
val z = Pair(0, 1)
fun day19_1(input: String): Pair<String, Int> {
    val maze = readMaze(input)
    val result = mutableListOf<Char>()
    val startX = maze.indexOfFirst { l -> l[0] != ' ' }
    var current = Pair(startX, 0)
    var direc = z
    while (true) {

        val next = peek(maze, current, direc)

        if (next == ' ') {
            val options = corner(direc)
            if (peek(maze, current, options[0]) != ' ') {
                direc = options[0]
            } else if (peek(maze, current, options[1]) != ' ') {
                direc = options[1]
            } else {
                break;
            }
        } else {
            result.add(next);
            current = add(current, direc)
        }
    }
    return Pair(result.filter { c -> c.isLetter() }.joinToString(""), result.size +1)
}

private fun peek(maze: List<List<Char>>, current: Pair<Int, Int>, direc: Pair<Int, Int>): Char {


    val x = current.first + direc.first
    val y = current.second + direc.second

    if (!(x in (0..maze.size - 1)) || !(y in (0..maze[0].size - 1))) {
        return ' '
    }
    return maze[x][y]
}


fun corner(direc: Pair<Int, Int>): List<Pair<Int, Int>> {
    if (direc == n || direc == z) {
        return listOf(o, w)
    } else {
        return listOf(n, z)
    }
}


fun add(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(p1.first + p2.first, p1.second + p2.second)
}

fun readMaze(input: String): List<List<Char>> {
    val readLines = readLines(input)
    val result = mutableListOf<MutableList<Char>>()

    val Y = readLines.size -1
    val X = readLines.map { l -> l.length }.max()!! -1

    for (x in 0..X) {
        result.add(mutableListOf())
        for (y in 0..Y) {
            result[x].add(' ')
        }
    }

    for (y in 0..readLines.size - 1) {
        for (x in 0..readLines[y].length - 1) {
            result[x][y] = readLines[y].elementAt(x)
        }
    }
    return result;
}