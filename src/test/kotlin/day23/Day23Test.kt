package day23

import day19.day19_1
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day23Test  : StringSpec() {
    init {

//
//        "Puzzle1" {
//            val comp = Day23("src/main/resources/day23/input.txt", 0)
//comp.run()
//            println(comp.count)
//        }


        "Puzzle2" {
            val comp = Day23("src/main/resources/day23/input.txt", 1)
            comp.run()
            println(comp.reg["h"])
        }
    }

}