package day7

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class Day7KtTest : StringSpec() {
    init {
        "Example" {
            day7_1("src/main/resources/day7/sample.txt") shouldBe "tknk"
        }
        "Puzzle 1" {
            day7_1("src/main/resources/day7/input.txt") shouldBe "uownj"
        }
        "Example 2" {
            day7_2("src/main/resources/day7/sample.txt") shouldBe "tknk"
        }
        "Puzzle" {
            day7_2("src/main/resources/day7/input.txt") shouldBe "uownj"
        }
    }
}