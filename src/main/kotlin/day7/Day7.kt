package day7


fun exercise1(filename: String):String {
    val lines = util.readLines(filename);

    val regex = Regex("([a-z]*) \\((\\d*)\\) -> ([a-z, ]*)").toPattern()
    val first = ArrayList<String>()
    val rest = ArrayList<String>()

    lines.forEach {
      val result = regex.matcher(it)
        if (result.matches()) {
            first.add(result.group(1))
            rest.addAll(result.group(3).split(',').map { l -> l.trim() })
        }
    }

    first.removeAll(rest);

    return first.get(0);
}


val weightMap = HashMap<String, Int>()
val childrenMap = HashMap<String, List<String>>()

fun exercise2(filename: String):String {
    val lines = util.readLines(filename);

    val regex = Regex("([a-z]*) \\((\\d*)\\) -> ([a-z, ]*)").toPattern()
    val regex2 = Regex("([a-z]*) \\((\\d*)\\)").toPattern()


    lines.forEach {
        if (it.contains("->")) {
            val result = regex.matcher(it)
result.matches()
            val name = result.group(1)
            val weight = result.group(2)
            val children = result.group(3).split(',').map { l -> l.trim() }

            weightMap.put(name, Integer.parseInt(weight))
            childrenMap.put(name, children)
        }
        else {
            val result = regex2.matcher(it)
result.matches()
            val name = result.group(1)
            val weight = result.group(2)

            weightMap.put(name, Integer.parseInt(weight))

        }
    }

return weightOfTree("uownj").toString()
}

fun weightOfTree(name: String): Int {
    var weight = weightMap.get(name)!!
    val children = childrenMap.get(name);
    if (children != null) {
        val map = children.map { i -> weightOfTree(i) }
        if (map.max() != map.min()) {
            println(name)
            println(map)
            println(weight)
        }
        return weight + map.sum()
    }
    else {
        return weight
    }
}