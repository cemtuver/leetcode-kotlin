class Solution {
    
    private fun fill(array: Array<IntArray>, n: Int, startIndex: Int, startFrom: Int) {
        if (n == 0) return
        if (n == 1) {
            array[startIndex][startIndex] = startFrom
            return
        }
        
        var current = startFrom
        val maxIndex = n - 1
        
        (0 until n).forEach { i -> array[startIndex][startIndex + i] = current++ }
        (1 until n).forEach { i -> array[startIndex + i][startIndex + maxIndex] = current++ }
        (1 until n).forEach { i -> array[startIndex + maxIndex][startIndex + maxIndex - i] = current++ }
        (1 until maxIndex).forEach { i -> array[startIndex + maxIndex - i][startIndex] = current++ }
        
        fill(array, n - 2, startIndex + 1, current)
    }

    fun generateMatrix(n: Int): Array<IntArray> {
        val array = Array(n) { IntArray(n) }
        
        fill(array, n, 0, 1)
        
        return array
    }

}