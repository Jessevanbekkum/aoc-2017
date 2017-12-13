package day13

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day13KtTest: StringSpec() {
    init {
        "Example" {
            p1("src/main/resources/day13/example.txt") shouldBe 24
        }

        "Puzzle" {
            p1("src/main/resources/day13/input.txt") shouldBe 1580
        }
        "Example" {
            p2("src/main/resources/day13/example.txt") shouldBe 10
        }

        "Puzzle" {
            p2("src/main/resources/day13/input.txt") shouldBe 3943252
        }

    }
}