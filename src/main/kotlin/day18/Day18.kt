package day18

import util.readLines

class Day18 {
    val snd = Regex("snd (\\w)")
    val set = Regex("set (\\w) ([\\w-]*)")
    val add = Regex("add (\\w) ([\\w-]*)")
    val mul = Regex("mul (\\w) ([\\w-]*)")
    val mod = Regex("mod (\\w) ([\\w-]*)")
    val rcv = Regex("rcv (\\w)")
    val jgz = Regex("jgz (\\w) ([\\w-]*)")
    val reg = mutableMapOf<String, Long>()
    val regex = listOf<Regex>(snd, set, add, mul, mod, rcv, jgz)

    init {
        "abcdefghijklmnopqrstuvwxyz".forEach { it -> reg.put(it.toString(), 0) }
    }

    fun day18_1(input: String): Long {
        val code = readLines(input)
        var lf :Long= 0
        var pos = 0;
        while (pos in (0..code.size)) {
            val s = code[pos]

            val caps = regex.map { r -> r.matchEntire(s) }.filterNotNull().first().groupValues

            when (caps[0].subSequence(0, 3)) {
                "snd" -> lf = read(caps[1])
                "set" -> reg[caps[1]] = read(caps[2])
                "rcv" -> if (lf != 0L) return lf;
                "mul" -> reg[caps[1]] = reg[caps[1]]!! * read(caps[2])
                "mod" -> reg[caps[1]] = reg[caps[1]]!! % read(caps[2])
                "add" -> reg[caps[1]] = reg[caps[1]]!! + read(caps[2])
                "jgz" -> if (reg[caps[1]]!! > 0) pos += read(caps[2]).toInt() - 1 else {}
            }

            pos++
        }

        return -666
    }

    fun read(s: String): Long {
        return s.toLongOrNull() ?: reg[s]!!
    }
}
