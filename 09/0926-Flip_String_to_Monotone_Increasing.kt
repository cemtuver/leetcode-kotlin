class Solution {

    fun minFlipsMonoIncr(s: String): Int {
        var left1s = 0
        var right0s = s.count { it == '0' }
        var minFlip = minOf(right0s, s.length - right0s)

        s.forEach { c ->
            when (c) {
                '0' -> right0s--
                '1' -> left1s++
            }

            minFlip = minOf(minFlip, left1s + right0s)
        }

        return minFlip
    }

}