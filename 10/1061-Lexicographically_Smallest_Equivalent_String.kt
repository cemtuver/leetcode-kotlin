class Solution {

    fun findRootIndex(equivalents: IntArray, c: Char): Int {
        var i = c.toInt() - 'a'.toInt()

        while (i != equivalents[i]) {
            i = equivalents[i]
        }

        return i
    }

    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val equivalents = IntArray(26) { i -> i }

        s1.zip(s2).forEach { (c1, c2) ->
            if (c1 != c2) {
                val i1 = findRootIndex(equivalents, c1)
                val i2 = findRootIndex(equivalents, c2)

                when {
                    i1 < i2 -> equivalents[i2] = i1
                    else -> equivalents[i1] = i2
                }
            }
        }

        return baseStr.map { 
            ('a'.toInt() + equivalents[findRootIndex(equivalents, it)]).toChar() 
        }.joinToString("")
    }

}