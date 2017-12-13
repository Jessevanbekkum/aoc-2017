package day9

import day8.parse
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.Assert.*

class Day9KtTest : StringSpec() {
    init {
        "Ring 0" {
            clean("{{<!!>},{<!!>},{<!!>},{<!!>}}") shouldBe  9
        }

        "Ring 0" {
            clean("{{<ab>},{<ab>},{<ab>},{<ab>}}") shouldBe  9
        }

        "Ring 0" {
            clean("{{<a!>},{<a!>},{<a!>},{<ab>}}") shouldBe  3
        }

        "Solution1" {
            val s= util.parseSingleString("src/main/resources/day9/input.txt")
            clean(s) shouldBe 3
        }


        "Ring 0" {
            countGarbage("<{o\"i!a,<{i<a>") shouldBe  10
        }

        "Solution2" {
            val s= util.parseSingleString("src/main/resources/day9/input.txt")
            countGarbage(s) shouldBe 3
        }
    }
}