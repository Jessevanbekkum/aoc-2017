package day12

fun read(path: String): Int {
    val readLines = util.readLines(path)

    val regex = Regex("^(\\d*) <-> (.*)$")
    var groups = mutableSetOf<MutableSet<Int>>()
    readLines.forEach {
        val match = regex.matchEntire(it)
        if (match != null) {
            val from = match.groupValues.get(1).toInt()
            val to = match.groupValues.get(2).split(',')
                    .map { s -> s.trim().toInt() }

            val subgroup = mutableSetOf(from)
            subgroup.addAll(to)

            val find = groups.filter { g -> !(g intersect subgroup).isEmpty() }

            if (find.isEmpty()) {
                groups.add(subgroup)
            } else {
                find.forEach{ it.addAll(subgroup)}
            }

            val newGroup = find.flatten().toMutableSet()
     groups =         groups.filter { g -> (g intersect newGroup).isEmpty()}.toMutableSet()
            groups.add(newGroup)
//            val filter = groups.filter { g ->
//                !(g intersect currentGroup).isEmpty()
//            }
//
//            if (filter.size > 1) {
//                filter[0].addAll(filter.flatten().toSet())
//                groups.removeAll(filter.drop(1))
//            }

        }
    }

    println(groups)
println(groups.filter { g -> !g.isEmpty() }.size)

    return groups.find { g -> g.contains(0) }!!.size
}