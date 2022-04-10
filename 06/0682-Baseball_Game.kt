class Solution {
    
    fun calPoints(ops: Array<String>): Int {
        val points = mutableListOf<Int>()
        
        ops.forEach { op ->
            when (op) {
                "+" -> points.add(points[points.size - 1] + points[points.size - 2])
                "D" -> points.add(points[points.size - 1] * 2)
                "C" -> points.removeAt(points.size - 1)
                else -> points.add(op.toInt())
            }
        }
        
        return points.sum()
    }

}

fun main() {
    val solution = Solution()
    val output = solution.calPoints(arrayOf("5", "2", "C", "D", "+"))

    println("Expected: 30")
    println("Actual  : $output")
}