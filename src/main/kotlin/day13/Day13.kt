package day13

fun p1(file: String): Int {
    val readLines = util.readLines(file);

    val regex = Regex("(\\d*): (\\d*)")
    val map = mutableMapOf<Int, Int>()
    readLines.map { it -> regex.find(it) }
            .filterNotNull()
            .forEach { it -> map.put(it.groupValues.get(1).toInt(), it.groupValues.get(2).toInt()) }

    var hits = 0;

    map.forEach { k, v ->
        if (k % ((v - 1) * 2) == 0) {
            hits += k * v
        }
    }

    return hits
}

fun p2(file: String): Int {
    val readLines = util.readLines(file);

    val regex = Regex("(\\d*): (\\d*)")
    val map = mutableMapOf<Int, Int>()
    readLines.map { it -> regex.find(it) }
            .filterNotNull()
            .forEach { it -> map.put(it.groupValues.get(1).toInt(), it.groupValues.get(2).toInt()) }

    var n = 0;
    while (true) {
        val count = map.entries.takeWhile { (k, v) -> ((n + k) % ((v - 1) * 2)) != 0 }.count()
        if (count == map.size) {
            break;
        } else {
            n++
        }
    }
    return n
}