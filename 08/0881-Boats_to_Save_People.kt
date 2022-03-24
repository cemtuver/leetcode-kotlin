class Solution {

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        var boats = 0
        var left = 0
        var right = people.size - 1
        var sortedPeople = people.sorted()
        
        while (left <= right) {
            if (sortedPeople[left] + sortedPeople[right] <= limit) {
                left++
            }
            
            right--
            boats++
        }
        
        return boats
    }

}

fun main() {
    val solution = Solution()
    val output = solution.numRescueBoats(intArrayOf(3, 2, 2, 1), 3)

    println("Expected: 3")
    println("Actual  : $output")
}