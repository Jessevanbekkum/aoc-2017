package day14

import day10.hash64

fun hash(input: String): Int {
    val toIntArray = (0..127).map { it ->
        val s = hash64(input + "-" + it)
        s.toCharArray().map { c -> countBits(c) }.sum()
    }.toIntArray()
    return toIntArray.sum()
}

fun countBits(inp: Char): Int {
    return Integer.valueOf(inp.toString(), 16).toString(2).toCharArray().filter { c -> c == '1' }.count()
}

fun hashSquare(input: String): MutableList<MutableList<Char>> {
    val array = (0..127).map { it ->
        val s = hash64(input + "-" + it)
        assert(s.length == 32)
        s.toCharArray().map { c -> bitRow(c) }.flatten().toMutableList()
    }
    assert(array.size == 128)
    return array.toMutableList()
}

fun bitRow(inp: Char): List<Char> {
   return  (16 + Integer.valueOf(inp.toString(), 16)).toString(2).map { c ->
        when {
            c == '0' -> '.'
            else -> '#'
        }
    }.subList(1, 5)

}

fun countAreas(sq: MutableList<MutableList<Char>>): Int {
    var c = 0
    (0..127).forEach { x ->
        (0..127).forEach { y ->
            run {
                if (sq[x][y] == '#') {
                    clean(sq, x, y)
                    c++
                }
            }
        }
    }
    return c
}

fun clean(sq: MutableList<MutableList<Char>>, x: Int, y: Int) {
    if (x < 0 || x > 127 || y < 0 || y > 127 || sq[x][y] == '.') {
        return
    } else {
        sq[x][y] = '.'
        clean(sq, x - 1, y)
        clean(sq, x + 1, y)
        clean(sq, x, y - 1)
        clean(sq, x, y + 1)

    }
}