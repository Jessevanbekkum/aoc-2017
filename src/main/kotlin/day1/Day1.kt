package day1

import util.parseSingleString


fun main(args: Array<String>) {
    println(digit(parseSingleString("src/main/resources/day1/input.txt")))
    println(digit2(parseSingleString("src/main/resources/day1/input.txt")))
}


fun  digit( s:String):Int {
    var sum = 0;
    for ( (index, value) in s.toCharArray().withIndex()) {
        if (value == s.get(((index + 1) % s.length))) {
            sum = sum.plus( Character.digit(value, 10))
        }
    }

    return sum;
}

fun  digit2( s:String):Int {
    var sum = 0;
    val diff = s.length /2;
    for ((i, value) in s.toCharArray().withIndex()) {
        if (value == s.get((i+diff) % s.length)) {
            sum += Integer.parseInt(s.substring(i,i+1));
        }
    }

    return sum;
}
