class Solution {

    fun minimumRounds(tasks: IntArray): Int {
        var round = 0
        val levelMap = mutableMapOf<Int, Int>()

        tasks.forEach { 
            levelMap[it] = levelMap.getOrDefault(it, 0) + 1
        }

        for (count in levelMap.values) {
            if (count == 1) return -1
            round += (count / 3) + (if (count % 3 == 0) 0 else 1)
        }

        return round
    }

}