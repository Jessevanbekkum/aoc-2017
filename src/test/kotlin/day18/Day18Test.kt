package day18

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day18Test : StringSpec() {
    init {

        "Example" {
            val day18 = Day18()
            day18.day18_1("src/main/resources/day18/example.txt.txt") shouldBe 4

        }

        "Puzzle1" {
            val day18 = Day18()
            day18.day18_1("src/main/resources/day18/input.txt") shouldBe 4

        }

        "Example" {
            val res = run("src/main/resources/day18/example2.txt")

            val p1 = res.first
            val p2 = res.second
            p1.sent shouldBe p2.received
            p2.sent shouldBe p1.received
            p1.sent shouldBe 3

        }



        "Puzzle 2" {
            val res = run("src/main/resources/day18/input.txt")

            val p1 = res.first
            val p2 = res.second
            p1.sent shouldBe p2.received
            p2.sent shouldBe p1.received
            p1.sent shouldBe 3
        }

    }

}