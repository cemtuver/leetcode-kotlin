class Solution {

    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val trustDiffs = IntArray(n + 1) { 0 }

        trust.forEach {
            trustDiffs[it[0]]--
            trustDiffs[it[1]]++
        }

        for (i in 1..n) {
            if (trustDiffs[i] == n - 1) {
                return i
            }
        }

        return -1
    }

}