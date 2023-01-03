class Solution {

    fun minDeletionSize(strs: Array<String>): Int {
        var columnsToDelete = 0
        val rows = strs.count()
        val columns = strs[0].length

        for (i in 0..(columns - 1)) {
            var left = 0
            var right = 1
            
            while (right < rows) {
                if (strs[left][i] > strs[right][i]) {
                    columnsToDelete++
                    break
                }

                left++
                right++
            }
        }

        return columnsToDelete
    }

}