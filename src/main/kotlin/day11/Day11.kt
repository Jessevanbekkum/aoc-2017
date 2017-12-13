package day11

import java.lang.Integer.min
import java.util.function.BiFunction

fun walk(input: String):Int {
    val split = input.split(',')
return walk(split)

}

fun walk (split:List<String>):Int {
    val counters = mutableMapOf<String, Int>()
    val dirs = listOf("n", "ne", "se", "s", "sw", "nw")
    dirs.forEach { counters.put(it, 0) }
    split.forEach { counters.compute(it, {k, v -> v?.plus(1)})}

    removeOpposites(counters)
    reduce(counters)

    return counters.values.sum()
}
fun furthest(input:String):Int {
    val split = input.split(',')
    var max = 0
    (0..split.size).forEach{
        max = Math.max(max, walk(split.subList(0, it)))

    }
    return max
}

fun removeOpposites(counters: MutableMap<String, Int>) {
    val ns = Pair("n", "s")
    val nesw = Pair("ne", "sw")
    val nwse = Pair("nw", "se")
    val ops = listOf<Pair<String, String>>(ns, nesw, nwse)

    ops.forEach {
        val smallest = min(counters.get(it.first)!!, counters.get(it.second)!!)
        counters.put(it.first, counters.get(it.first)!! - smallest)
        counters.put(it.second, counters.get(it.second)!! - smallest)
    }
}

fun reduce(counters: MutableMap<String, Int>) {
    val reducables = listOf(Pair(Pair("n", "sw"), "nw")
            , Pair(Pair("n", "se"), "ne")
            , Pair(Pair("s", "nw"), "sw")
            , Pair(Pair("s", "ne"), "se")
            , Pair(Pair("ne", "nw"), "n")
            , Pair(Pair("se", "sw"), "s"))

    var changes = false
    do {
        changes = false
        reducables.forEach {
            if (counters.get(it.first.first)!! > 0 &&
                    counters.get(it.first.second)!! > 0){
                counters.compute(it.first.first, { k, v -> v?.minus(1) });
                counters.compute(it.first.second, { k, v -> v?.minus(1) });
                counters.compute(it.second, { k, v -> v?.plus(1) });
                changes = true
            }
        }
    }while (changes)
}
