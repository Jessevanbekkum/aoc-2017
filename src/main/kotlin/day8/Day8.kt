package day8

import util.readLines

fun parse(file: String): Int {
    val lines = readLines(file)

    val regex = Regex("(\\w*) (\\w*) ([\\d-]*) if (\\w*) ([\\W]*) ([\\d-]*)")
    val map = mutableMapOf<String, Int>()
    val list = mutableListOf<Line>()
    lines.forEach {
        val m = regex.matchEntire(it)

        val value = Line(m!!)
        map.put(value.name, 0)
        list.add(value)
    }

    var i = 0;
  var  max = Integer.MIN_VALUE
    while (i < list.size){
        val c = list[i]
        max = Math.max( c.act(map), max)
            i++;
    }
    println(max)
    return map.map { it -> it.value }.filterNotNull().max()!!

}