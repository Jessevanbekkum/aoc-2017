package day12

import day10.doit
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.Assert.*

class Day12KtTest  : StringSpec() {
    init {
        "Example" {
            read("src/main/resources/day12/example.txt.txt") shouldBe 6
        }

        "Puzzle" {
            read("src/main/resources/day12/input.txt") shouldBe 6
        }


    }
}