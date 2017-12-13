package day3

import day3.ringSize
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldHave
import io.kotlintest.specs.StringSpec
import io.kotlintest.matchers.*

class MyTests : StringSpec() {
    init {
        "Ring 0" {
            ringSize(0) shouldBe 1
        }
        "Ring 1 " {
            ringSize(1) shouldBe 8
        }

        "Ring 2" {
            ringSize(2) shouldBe 16
        }

        "Middles" {
            middles(2) shouldBe listOf(11,15,19,23)
        }

        "Path of 12" {
            path(12) shouldBe 3;
        }

        "Path of 23" {
            path(23) shouldBe 2;
        }

        "Path of 1024" {
            path(1024) shouldBe 31;
        }

        "Solution is 430" {
            path(312051) shouldBe 430;
        }

        "Get coordinates 1" {
            getCoordinates(1) shouldBe Pair(0,0)
        }

        "Get coordinates 2" {
            getCoordinates(2) shouldBe Pair(1,0)
        }

        "Get coordinates 9" {
            getCoordinates(9) shouldBe Pair(1,-1)
        }

        "Get coordinates 20" {
            getCoordinates(20) shouldBe Pair(-2,-1)
        }

        "Neighbours 2" {
            neighbours(2) should contain(Pair(0,0))
        }

        "First larger" {
            firstLarger(804) shouldBe(806)
        }

        "First larger2" {
            firstLarger(312051) shouldBe(312453)
        }

    }
}