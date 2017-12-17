package day16

import util.readLines

fun day16_1(input: String, p: Int): String {
    val choreo = readLines(input).joinToString("").split(",")

    val start = "abcdefghijklmnop".substring(0, p)
    return boogie(start, choreo).joinToString("")
}

fun boogie(start: String, choreo: List<String>): MutableList<Char> {
    var dance = start.toMutableList()
    val p = start.length
    val spin = Regex("s(\\d+)")
    val exch = Regex("x(\\d+)/(\\d+)")
    val partn = Regex("p(\\w)/(\\w)")
    choreo.forEach(
            { s ->
                val matchResult1 = spin.matchEntire(s)
                if (matchResult1 != null) {
                    val fromIndex = matchResult1.groupValues[1].toInt()
                    dance = (dance.takeLast(fromIndex) + dance.take(p - fromIndex)).toMutableList()
                }
                val matchResult2 = exch.matchEntire(s)?.groupValues?.drop(1)?.map { z -> z.toInt() }
                if (matchResult2 != null) {
                    val a = matchResult2[0]
                    val b = matchResult2[1]
                    val swap = dance[a]
                    dance[a] = dance[b]
                    dance[b] = swap
                }
                val mr3 = partn.matchEntire(s)?.groupValues?.drop(1)?.map { z -> z.toCharArray()[0] }
                if (mr3 != null) {
                    val a = mr3[0]
                    val b = mr3[1]
                    val pa = dance.indexOf(a)
                    val pb = dance.indexOf(b)
                    dance[pa] = b
                    dance[pb] = a
                }
            }
    )

    return dance;
}

fun day16_2(input: String, p: Int, f: Int): String {
    val choreo = readLines(input).joinToString("").split(",")

    var start = "abcdefghijklmnop".substring(0, p)

    (0..f - 1).forEach({
        start = boogie(start, choreo).joinToString("")
    })

    return start
}