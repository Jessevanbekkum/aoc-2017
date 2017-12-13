package day8

import day7.exercise1
import day7.exercise2
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.Assert.*


class MyTests : StringSpec() {
    init {
        "Ring 0" {
            parse("src/main/resources/day8/example.txt") shouldBe 1
        }
        "Ring 0" {
            parse("src/main/resources/day8/input.txt") shouldBe 1
        }
    }
}