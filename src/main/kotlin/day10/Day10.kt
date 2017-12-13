package day10

fun doit(listLength:Int, input: List<Int>):Int {
    var list = mutableListOf<Int>()

    ( 0..listLength -1).forEach{
        list.add(it)
    }

    var p = 0;
    var skip = 0;

    input.forEach {
        val length = it
        val end = (p + length) % list.size
        val p2:List<Int>
        if (end <= p) {
            p2 = list.subList(p, list.size) + list.subList(0, end)
        }else {
             p2 = list.subList(p, p + length)
        }
        val inv = p2.reversed()
        var c = 0
        (p..(p+length-1)).forEach{
            val nc = inv[c]
            list[it % list.size] = nc
            c++
        }
        println(list)
        p = (p + it + skip) % list.size
        skip ++
    }

    return list[0] * list[1]
}

