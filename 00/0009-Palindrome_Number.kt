class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        
        var left = 0
        var right = str.length - 1
        val str = x.toString()

        while (left < right) {
            if (str[left] != str[right]) {
                return false
            }

            left++
            right--
        }

        return true
    }
}