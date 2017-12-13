package day8

//bz inc 329 if hri < 6

class Line( m: MatchResult) {

     val name = m.groupValues.get(1);
    val op = m.groupValues.get(2);
    val mod = Integer.parseInt(m.groupValues[3])
    val condReg = m.groupValues[4]
    val condOp = m.groupValues[5]
    val condVal = Integer.parseInt(m.groupValues[6])

    fun act(memory: MutableMap<String, Int>): Int {
        val other = memory.get(condReg)!!;

        var co = false
        when(condOp) {
            "<" ->  co = other < condVal
            ">" ->  co = other > condVal
            ">=" ->  co = other >= condVal
            "<=" ->  co = other <= condVal
            "==" ->  co = other == condVal
            "!=" ->  co = other != condVal
            else -> throw Exception("WHAA")
        }

        if (co){
            when(op) {
                "dec" -> memory.put(name, memory.get(name)!! - mod)
                "inc" -> memory.put(name, memory.get(name)!! + mod)
            }
        }
        return memory.get(name)!!
    }
}