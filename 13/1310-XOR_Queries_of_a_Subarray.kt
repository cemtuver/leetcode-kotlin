class Solution {

    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val results = IntArray(arr.size)
        val lookup = IntArray(arr.size + 1) { 0 }

        arr.forEachIndexed { index, number ->
            lookup[index + 1] = lookup[index].xor(number)
        }

        queries.forEachIndexed { index, query ->
            val from = query[0]
            val to = query[1]
            val result = lookup[to + 1].xor(lookup[from])

            results[index] = result
        }

        return results
    }

}

fun main() {
    val solution = Solution()
    val arr = intArrayOf(1, 3, 4, 8)
    val queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(3, 3))
    val output = solution.xorQueries(arr, queries).toList()

    println("Expected: [2, 7, 14, 8]")
    println("Actual  : $output")
}
