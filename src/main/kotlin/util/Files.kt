package util

import java.io.File

fun parseListOfListOfNumbers(filename: String): List<List<Int>> {
    val bufferedReader = File(filename).bufferedReader()
    val lineList = mutableListOf<List<Int>>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it.split('\t').map { s -> Integer.parseInt(s) }) } }

    return lineList;
}

fun parseSingleString(filename: String):String{
    return File(filename).readText()
}