package day20

import day19.day19_1
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.Assert.*

class Day20KtTest  : StringSpec() {
    init {

//
//        "Example" {
//            day20_1("src/main/resources/day20/example.txt")  shouldBe 0
//        }
//
//
//
//        "Puzzle 1" {
//
//            day20_1("src/main/resources/day20/input.txt")  shouldBe 376
//
//        }
        "Example" {
            day20_2("src/main/resources/day20/example2.txt")  shouldBe 1
        }

        "Puzzle 2" {
            day20_2("src/main/resources/day20/input.txt")  shouldBe 1
        }
    }

}