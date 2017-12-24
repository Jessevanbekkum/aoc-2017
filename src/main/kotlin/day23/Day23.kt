package day23

import util.readLines

class Day23(input: String, a: Long) {
    val set = Regex("set (\\w) ([\\w-]*)")
    val mul = Regex("mul (\\w) ([\\w-]*)")
    val sub = Regex("sub (\\w) ([\\w-]*)")
    val jnz = Regex("jnz (\\w) ([\\w-]*)")
    val reg = mutableMapOf<String, Long>()
    val regex = listOf<Regex>(set, mul, sub, jnz)

    var count = 0


    var running = true;
    var pos = 0;
    val code: List<String>;

    init {
        "abcdefgh".forEach { it -> reg.put(it.toString(), 0) }
        reg["a"] = a
        code = readLines(input)
    }

    fun run() {
        while (pos in (0 until code.size)) {
            if ( pos==19) {
                println(pos.toString() + " - " + reg)
            }
            val s = code[pos]
            running = true
            val caps = regex.map { r -> r.matchEntire(s) }.filterNotNull().first().groupValues

            when (caps[0].subSequence(0, 3)) {
                "set" -> setRegister(caps)
                "sub" -> subtract(caps)
                "mul" -> multiply(caps)
                "jnz" -> jump(caps)
            }
        }
    }

    private fun subtract(caps: List<String>) {
        reg[caps[1]] = reg[caps[1]]!! - read(caps[2])
        pos++
    }

    private fun add(caps: List<String>) {
        reg[caps[1]] = reg[caps[1]]!! + read(caps[2])
        pos++
    }

    private fun modulo(caps: List<String>) {
        reg[caps[1]] = reg[caps[1]]!! % read(caps[2])
        pos++
    }


    private fun multiply(caps: List<String>) {
        count++
        reg[caps[1]] = reg[caps[1]]!! * read(caps[2])
        pos++
    }

    private fun setRegister(caps: List<String>) {
        reg[caps[1]] = read(caps[2])
        pos++
    }

    private fun jump(caps: List<String>) {
        if (read(caps[1]) != 0L) {
            pos += read(caps[2]).toInt()
        } else {
            pos++
        }
    }


    fun read(s: String): Long {
        return s.toLongOrNull() ?: reg[s]!!
    }
}