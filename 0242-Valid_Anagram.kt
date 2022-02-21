class Solution {
    
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val map = mutableMapOf<Char, Int>()
        
        s.forEach { char -> 
            map[char] = map.getOrDefault(char, 0) + 1 
        }
        
        t.forEach { char ->
            if (!map.contains(char)) return false
            
            when (val count = map.getValue(char)) {
                1 -> map.remove(char)
                else -> map[char] = count - 1
            }
        }
        
        return map.isEmpty()
    }

}

fun main() {
    val solution = Solution()
    val output = solution.isAnagram("anagram", "nagaram")

    println("Expected: true")
    println("Actual  : $output")
}
