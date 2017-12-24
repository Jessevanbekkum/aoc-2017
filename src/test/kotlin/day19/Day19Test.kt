package day19

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day19Test : StringSpec() {
    init {


        "Example" {
            val res = day19_1("src/main/resources/day19/example.txt")

            res.first shouldBe "ABCDEF"
res.second shouldBe 38
        }



        "Puzzle 1" {
            val res = day19_1("src/main/resources/day19/input.txt")

            res.first shouldBe "MOABEUCWQS"
            res.second shouldBe 18058

        }

    }

}