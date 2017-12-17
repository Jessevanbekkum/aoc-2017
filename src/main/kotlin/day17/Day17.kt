package day17

fun day17_1(input: Int): Int {
    val buffer = mutableListOf(0)
    var pos = 0;

    (1..2017).forEach {
        pos = (pos + input) % buffer.size + 1
        buffer.add(pos, it)
    }

    return buffer[(pos + 1) % buffer.size]
}

fun day17_2(input: Int): Int {
    var pos = 0;
    var pOfZero = 0
    var afterZero = 0
    (1..50_000_000).forEach {
        pos = (pos + input) % it + 1
        if (pos <= pOfZero) {
            pOfZero++
        }
        if (pos == pOfZero + 1) {
            afterZero = it
        }
    }

    return afterZero
}