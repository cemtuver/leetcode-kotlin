class Solution {
    
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        
        var sIndex = 0
        var tIndex = 0
        
        while (tIndex < t.length) {
            if (s[sIndex] == t[tIndex]) {
                sIndex++
                if (sIndex == s.length) return true
            }
            
            tIndex++
        }
        
        return false
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.isSubsequence("abc", "ahbgdc")

    println("Expected: true")
    println("Actual  : $output")
}