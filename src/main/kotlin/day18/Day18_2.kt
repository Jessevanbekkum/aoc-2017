package day18

import util.readLines

class Day18_2(val p: Long, input: String) {
    val snd = Regex("snd (\\w)")
    val set = Regex("set (\\w) ([\\w-]*)")
    val add = Regex("add (\\w) ([\\w-]*)")
    val mul = Regex("mul (\\w) ([\\w-]*)")
    val mod = Regex("mod (\\w) ([\\w-]*)")
    val rcv = Regex("rcv (\\w)")
    val jgz = Regex("jgz (\\w) ([\\w-]*)")
    val reg = mutableMapOf<String, Long>()
    val regex = listOf<Regex>(snd, set, add, mul, mod, rcv, jgz)

    val buffer = mutableListOf<Long>()

    var running = true;
    var pos = 0;
    val code: List<String>;
    var sent = 0
    var received = 0
    var other: Day18_2? = null

    init {
        "abfip".forEach { it -> reg.put(it.toString(), 0) }

        reg["p"] = p
        code = readLines(input)
    }

    fun run() {
        if (!(pos in (0..code.size))) {
            running = false
            return
        }
        val s = code[pos]
        running = true
        val caps = regex.map { r -> r.matchEntire(s) }.filterNotNull().first().groupValues

        when (caps[0].subSequence(0, 3)) {
            "snd" -> sendBuffer(caps)
            "set" -> setRegister(caps)
            "rcv" -> receive(caps)
            "mul" -> multiply(caps)
            "mod" -> modulo(caps)
            "add" -> add(caps)
            "jgz" -> jump(caps)
        }
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
        reg[caps[1]] = reg[caps[1]]!! * read(caps[2])
        pos++
    }

    private fun setRegister(caps: List<String>) {
        reg[caps[1]] = read(caps[2])
        pos++
    }

    private fun jump(caps: List<String>) {
        if (read(caps[1]) > 0) {
            pos += read(caps[2]).toInt()
        } else {
            pos++
        }
    }

    private fun sendBuffer(caps: List<String>) {
        sent++
        other!!.buffer.add(read(caps[1]))
        pos++
    }

    private fun receive(caps: List<String>) {
        if (buffer.isEmpty()) {
            running = false
        } else {
            received++
            reg[caps[1]] = buffer.removeAt(0)
            pos++
        }
    }

    fun read(s: String): Long {
        return s.toLongOrNull() ?: reg[s]!!
    }
}


fun run(input: String): Pair<Day18_2, Day18_2> {
    val p1 = Day18_2(0, input)
    val p2 = Day18_2(1, input)

    p1.other = p2
    p2.other = p1

    while (true) {
        p1.run()
        p2.run()

        if (!p1.running && !p2.running) {
            break
        }


    }

    return Pair(p1, p2)
}