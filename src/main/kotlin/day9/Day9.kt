package day9

fun clean(input: String): Int {
    println(input
    )

    var working = input.replace(Regex("!."), "")
    println(working)

    working = working.replace(Regex("<.*?>"), "")
    println(working)

    working = working.replace(Regex("[^{}]*"), "")
    println(working)
    var groups = 0;

    var n = 0;
    var level = 0;
    while (n < working.length) {
        val c = working.elementAt(n)
        if (c.equals('{')) {
            level++
        }
        if (c.equals('}')) {
            groups += level
            level--
        }
        n++
    }
    return groups
}


fun countGarbage(input: String): Int {
    println(input
    )

    var working = input.replace(Regex("!."), "")

    var n = 0;
    var g = false
    var c = 0
    while (n < working.length) {
        val el = working.elementAt(n)

        if (g && !el.equals('>')) {
            c++
        } else {
            if (el.equals('<')) {
                g = true
            } else
                if (el.equals('>')) {
                    g = false;
                } else if (g) {
                    c++

                }
        }


    n++
}
return c
}