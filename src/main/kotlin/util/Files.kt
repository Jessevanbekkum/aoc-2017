package util

import java.io.File
import java.nio.charset.StandardCharsets

fun parseListOfListOfNumbers(filename: String): List<List<Int>> {
    val bufferedReader = File(filename).bufferedReader()
    val lineList = mutableListOf<List<Int>>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it.split('\t').map { s -> Integer.parseInt(s) }) } }

    return lineList;
}

fun readLines(filename: String): List<String> {
    return File(filename).readLines(StandardCharsets.UTF_8);
}
fun parseSingleString(filename: String):String{
    return File(filename).readText()
}