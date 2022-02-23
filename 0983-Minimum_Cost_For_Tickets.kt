class Solution {
    
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val travelDays = BooleanArray(366) { false }
        val minCosts = IntArray(366) { Int.MAX_VALUE }
        val lastDay = days.last()
        
        minCosts[0] = 0
        days.forEach { travelDays[it] = true }
        
        for (i in 1..lastDay) {            
            if (!travelDays[i]) {
                minCosts[i] = minCosts[i - 1]
                continue
            }
            
            minCosts[i] = minOf(
                minCosts[i - 1] + costs[0],
                minCosts.getOrElse(i - 7) { 0 } + costs[1],
                minCosts.getOrElse(i - 30) { 0 } + costs[2]
            )
        }
        
        return minCosts[lastDay]
    }

}

fun main() {
    val solution = Solution()
    val output = solution.mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15))

    println("Expected: 11")
    println("Actual  : $output")
}