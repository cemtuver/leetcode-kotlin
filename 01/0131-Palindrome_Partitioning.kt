class Solution {

    private fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (true) {
            if (s[left] != s[right]) return false
            if (left in right..(right + 1)) break

            left++
            right--
        }

        return true
    }

    private fun partition(current: Int, s: String, partition: MutableList<String>, partitions: MutableList<List<String>>) {
        if (current == s.length) {
            partitions.add(partition.toList())
            return
        }

        var currentString = ""

        for (i in current until s.length) {
            currentString += s[i]
            
            if (isPalindrome(currentString)) {
                partition.add(currentString)
                partition(i + 1, s, partition, partitions)
                partition.removeAt(partition.size - 1)
            }
        }
    }

    fun partition(s: String): List<List<String>> {
        val partition = mutableListOf<String>()
        val partitions = mutableListOf<List<String>>()

        partition(0, s, partition, partitions)

        return partitions
    }

}