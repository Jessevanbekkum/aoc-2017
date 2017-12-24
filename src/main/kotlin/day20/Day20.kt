package day20

import util.readLines
import java.lang.Math.abs

fun day20_1(input: String): Int {
    val particles = readLines(input).mapIndexed { i, s -> Particle(i, s) }.toMutableList()

    (0..1_000).forEach {
        particles.forEach { it.step() }
    }

    return particles.minBy { p -> p.sum() }!!.nr
}

fun day20_2(input: String): Int {
    val particles = readLines(input).mapIndexed { i, s -> Particle(i, s) }.toMutableList()

    (0..10_000).forEach {
        particles.forEach { it.step() }
        particles.sort()

        var i = 0;
        var j = 1;
        val booms = mutableListOf<Particle>()
        var currentSum = particles[0].sum()
        while (i < particles.size - 1) {
            if (boom(particles[i], particles[j])) {
                booms.add(particles[i])
                booms.add(particles[j])
            }
            j++
            if (j >= particles.size || particles[j].sum() != currentSum) {
                i++
                currentSum = particles[i].sum()
                j = i + 1
            }

        }
        particles.removeAll(booms)
    }

    return particles.size
}

fun boom(p1: Particle, p2: Particle): Boolean {
    return p1.pX == p2.pX && p1.pY == p2.pY && p1.pZ == p2.pZ
}

data class Particle(val nr: Int, val line: String) : Comparable<Particle> {
    override fun compareTo(other: Particle): Int {
        return this.sum() - other.sum()
    }

    var pX: Int
    var pY: Int
    var pZ: Int

    var vX: Int
    var vY: Int
    var vZ: Int

    val aX: Int
    val aY: Int
    val aZ: Int

    val lp = Regex("p=<(-?\\d*),(-?\\d*),(-?\\d*)>, v=<(-?\\d*),(-?\\d*),(-?\\d*)>, a=<(-?\\d*),(-?\\d*),(-?\\d*)>")

    init {
        val match = lp.matchEntire(line)
        pX = match!!.groupValues[1].toInt()
        pY = match.groupValues[2].toInt()
        pZ = match.groupValues[3].toInt()
        vX = match.groupValues[4].toInt()
        vY = match.groupValues[5].toInt()
        vZ = match.groupValues[6].toInt()
        aX = match.groupValues[7].toInt()
        aY = match.groupValues[8].toInt()
        aZ = match.groupValues[9].toInt()
    }

    fun sum(): Int {
        return abs(pX) + abs(pY) + abs(pZ)
    }

    fun step() {
        vX += aX
        vY += aY
        vZ += aZ

        pX += vX
        pY += vY
        pZ += vZ
    }

    override fun toString(): String {
        return nr.toString() + "-(" + pX + "," + pY + "," + pZ + ")"

    }
}