class Solution {
    
    fun minSteps(n: Int): Int {
        if (n == 1) return 0
        val operations = IntArray(n + 1) { 0 }
        
        for (i in 2..n) { 
            val mid = i / 2
            operations[i] = i
            
            for (j in mid downTo 2) {
                if (i % j == 0) {
                    operations[i] = operations[j] + (i / j)
                    break
                }
            }
        }
        
        return operations[n]
    }
    
}
 
fun main() {
    val solution = Solution()
    val output = solution.minSteps(3)

    println("Expected: 3")
    println("Actual  : $output")
}