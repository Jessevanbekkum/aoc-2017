package day2

import util.parseListOfListOfNumbers

fun main(args: Array<String>) {
    val lineList = parseListOfListOfNumbers("src/main/resources/day2/input.txt").map { l -> l.sorted() };

    val diffs = mutableListOf<Int>()
    lineList.forEach {
        val dif = it.last() - it.first()
        diffs.add(dif)
    }
    println(diffs.sum())

    println(lineList.map { l -> findEvenlyDivisable(l) }.sum())

}


fun findEvenlyDivisable(list: List<Int>): Int {
    val myList = list.sorted().reversed()
    var i = 0;
    var j = 1;
    while (myList[i] % myList[j] != 0) {
        j++;
        if (j == myList.size) {
            i++;
            j = i + 1
        }
    }
    return myList[i] / myList[j];
}