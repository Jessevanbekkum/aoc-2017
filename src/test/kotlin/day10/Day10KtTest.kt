package day10

import day9.clean
import day9.countGarbage
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.Assert.*

class Day10KtTest : StringSpec() {
    init {
        "Example" {
            doit(5, listOf(3, 4, 1, 5)) shouldBe 12
        }


        "Puzzle 1" {
            doit(256, listOf(230,1,2,221,97,252,168,169,57,99,0,254,181,255,235,167)) shouldBe 2928
        }

    }
}