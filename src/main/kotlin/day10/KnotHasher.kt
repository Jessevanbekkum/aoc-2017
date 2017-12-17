package day10


fun hash64(input: String): String {
    val length = convert(input);

    return hex(dense(hash(length, 64)));
}

fun hex(input: List<Int>): String {
    return input.map { i -> hexChar(i) }.joinToString("")
}

fun hexChar(i: Int): String {
    val c = java.lang.Integer.toHexString(i)
    if (i < 16) {
        return "0" + c
    }
    return c;
}

fun dense(l: List<Int>): List<Int> {
    if (l.isEmpty()) {
        return emptyList()
    } else {
        return xor(l.take(16)) + dense(l.subList(16, l.size))

    }
}


fun xor(l: List<Int>): List<Int> {
    return listOf(l.fold(0, { total, next -> total xor next }))
}

fun convert(s: String): List<Int> {
    return s.toCharArray().map { c -> c.toInt() } + listOf<Int>(17, 31, 73, 47, 23)
}


fun hash(input: List<Int>, repeat: Int): List<Int> {

    var p = 0
    var skip = 0

    val list = mutableListOf<Int>()

    (0..255).forEach {
        list.add(it)
    }

    (1..repeat).forEach {
        input.forEach {
            val length = it
            val end = (p + length) % list.size
            val p2: List<Int>
            if (end <= p) {
                p2 = list.subList(p, list.size) + list.subList(0, end)
            } else {
                p2 = list.subList(p, p + length)
            }
            val inv = p2.reversed()
            var c = 0
            (p..(p + length - 1)).forEach {
                val nc = inv[c]
                list[it % list.size] = nc
                c++
            }
            p = (p + it + skip) % list.size
            skip++
        }
    }

    return list
}
