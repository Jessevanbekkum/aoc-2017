package day24

import io.kotlintest.matchers.shouldBe
import org.junit.Test

import org.junit.Assert.*

class Day24KtTest {
    @Test
    fun example() {

        day24.strongest("src/main/resources/day24/example.txt") shouldBe 31
    }

    @Test
    fun puzzle1() {

        day24.strongest("src/main/resources/day24/input.txt") shouldBe 1906
    }

    @Test
    fun example2() {

        day24.longest("src/main/resources/day24/example.txt") shouldBe 19
    }

    @Test
    fun puzzle2() {

        day24.longest("src/main/resources/day24/input.txt") shouldBe 1824
    }
}