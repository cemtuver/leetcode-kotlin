class Solution {

    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0
        val n = prices.size - 1
        var buy = 0
        var sell = 0
        var profit = 0
        
        while (buy < n) {
            while (buy < n && prices[buy + 1] <= prices[buy]) {
                buy++
            }
            
            sell = buy
            
            while (sell < n && prices[sell + 1] >= prices[sell]) {
                sell++
            }
            
            profit += prices[sell] - prices[buy]
            buy = sell + 1
        }    
        
        return profit
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))

    println("Expected: 7")
    println("Actual  : $output")
}
