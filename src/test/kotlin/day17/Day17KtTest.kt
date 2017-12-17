package day17

import day16.day16_1
import day16.day16_2
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.Assert.*

class Day17KtTest : StringSpec() {
    init {

        "Example" {
            day17_1(3) shouldBe 638
        }
        "Puzzle 1" {
            day17_1(328) shouldBe 1670
        }

        "Puzzle 2" {
            day17_2(328) shouldBe 2316253
        }

        "Albert" {
            albert(328)
        }
    }
}