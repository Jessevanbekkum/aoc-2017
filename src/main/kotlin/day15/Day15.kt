package day15

fun calc(a: Int, b: Int): Int {
    var aa: Long = a.toLong()
    var bb: Long = b.toLong()
    var col = 0
    (0..40_000_000).forEach({
        aa = aa * 16807 % 2147483647
        bb = bb * 48271 % 2147483647

        if (aa % 65536 == bb % 65536) {
            col++
        }
    }
    )

    return col;
}

fun day15_2(a: Int, b: Int): Int {
    var aa: Long = a.toLong()
    var bb: Long = b.toLong()
    val aas = mutableListOf<Int>()
    val bbs = mutableListOf<Int>()
    while (aas.size < 5_000_000 || bbs.size < 5_000_000) {
        aa = aa * 16807 % 2147483647
        bb = bb * 48271 % 2147483647


        if (aa % 4L == 0L) {
            aas.add(aa.toInt())

        }
        if (bb % 8L == 0L) {
            bbs.add(bb.toInt())
        }
    }
    var col = 0;
    (0..4_999_999).forEach({
        if (aas[it] % 65536 == bbs[it] % 65536) {
            col++
        }
    }
    )

    return col;
}