package day7

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class MyTests : StringSpec() {
    init {
        "Ring 0" {
            exercise1("src/main/resources/day7/sample.txt") shouldBe "tknk"
        }
        "Ring 0" {
            exercise1("src/main/resources/day7/input.txt") shouldBe "uownj"
        }
        "Ring 0" {
            exercise2("src/main/resources/day7/sample.txt") shouldBe "tknk"
        }
        "Ring 0" {
            exercise2("src/main/resources/day7/input.txt") shouldBe "uownj"
        }
    }
}