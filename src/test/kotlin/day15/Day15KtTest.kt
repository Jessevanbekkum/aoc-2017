package day15

import day14.*
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day15KtTest : StringSpec() {
    init {

        "Example" {
            calc(65, 8921) shouldBe 588
        }

        "Example" {
            calc(883, 879) shouldBe 609
        }

        "Example" {
            day15_2(65, 8921) shouldBe 309
        }
        "Example" {
            day15_2(883, 879) shouldBe 309
        }
    }
}