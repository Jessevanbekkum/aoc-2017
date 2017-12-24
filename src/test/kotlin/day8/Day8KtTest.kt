package day8

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class Day8Test : StringSpec() {
    init {
        "Example" {
            parse("src/main/resources/day8/example.txt.txt") shouldBe 1
        }
        "Puzzle 1" {
            parse("src/main/resources/day8/input.txt") shouldBe 5966
        }
    }
}