package day14

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day14Test : StringSpec() {
    init {
        "Xor" {
            countBits('1') shouldBe 1
            countBits('4') shouldBe 1
            countBits('5') shouldBe 2
            countBits('e') shouldBe 3
            countBits('f') shouldBe 4
        }

        "Example" {
            hash("flqrgnkx") shouldBe 8108
        }

        "Example" {
            hash("hfdlxzhv") shouldBe 8108
        }

        "Example2" {
            countAreas(hashSquare("flqrgnkx")) shouldBe 1242
        }

        "Example3" {
            countAreas(hashSquare("hfdlxzhv")) shouldBe 1242
        }

        "BitRow" {
            String(bitRow('0').toCharArray()) shouldBe "...."
            String(bitRow('1').toCharArray()) shouldBe "...#"
            String(bitRow('e').toCharArray()) shouldBe "###."
            String(bitRow('f').toCharArray()) shouldBe "####"
        }
    }
}