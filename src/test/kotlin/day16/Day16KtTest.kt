package day16

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day16KtTest : StringSpec() {
    init {

        "Example" {
            day16_1("src/main/resources/day16/example.txt.txt", 5) shouldBe "baedc"
        }

        "Puzzle1" {
            day16_1("src/main/resources/day16/input.txt", 16) shouldBe "bijankplfgmeodhc"
        }

        "Puzzle2" {
            day16_2("src/main/resources/day16/example.txt.txt", 5, 2) shouldBe "ceadb"
        }


        "Puzzle2" {
            day16_2("src/main/resources/day16/input.txt", 16, 1_000_000_000 % 36) shouldBe "bpjahknliomefdgc"
        }
    }
}