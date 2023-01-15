class Solution {

    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelsSet = jewels.toHashSet()
        return stones.count { jewelsSet.contains(it) }
    }

}