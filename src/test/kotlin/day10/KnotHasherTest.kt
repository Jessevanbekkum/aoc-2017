package day10

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class KnotHasherTest : StringSpec() {
    init {
        "ByteReader" {
            convert("1,2,3") shouldBe listOf(49, 44, 50, 44, 51, 17, 31, 73, 47, 23)
        }

        "ToHex" {
            hex(listOf(64, 7, 255)) shouldBe "4007ff"
        }

        "Xor" {
            xor(listOf(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22)) shouldBe listOf(64)
        }

        "Previous" {
            hash(listOf(230, 1, 2, 221, 97, 252, 168, 169, 57, 99, 0, 254, 181, 255, 235, 167), 1).take(2) shouldBe listOf(16, 183)
        }

        "Empty" {
            hash64("") shouldBe "a2582a3a0e66e6e86e3812dcb672a272"
        }


        "AoC 2017" {
            hash64("AoC 2017") shouldBe "33efeb34ea91902bb2f59c9920caa6cd"
        }
        "1,2,3" {
            hash64("1,2,3") shouldBe "3efbe78a8d82f29979031a4aa0b16a9d"
        }

        "1,2,4" {
            hash64("1,2,4") shouldBe "63960835bcdc130f0b66d7ff4f6a5a8e"
        }

        "Solution" {
            hash64("230,1,2,221,97,252,168,169,57,99,0,254,181,255,235,167") shouldBe "0c2f794b2eb555f7830766bf8fb65a16"
        }
    }
}