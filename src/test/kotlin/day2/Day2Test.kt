package day2

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class MyTests : StringSpec() {
    init {

        "Example 1" {
            findEvenlyDivisable(listOf(5, 9, 2, 8)) shouldBe 4
        }

    }
}