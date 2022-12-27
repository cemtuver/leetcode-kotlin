class Solution {

    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        var fullBags = 0
        var remainingRocks = additionalRocks
        val emptySpaces = capacity.mapIndexed { i, capacity -> capacity - rocks[i] }.sorted()

        var emptySpaceIndex = 0
        while (remainingRocks > 0 && emptySpaceIndex < emptySpaces.size) {
            if (remainingRocks < emptySpaces[emptySpaceIndex]) {
                break
            }

            remainingRocks -= emptySpaces[emptySpaceIndex]
            emptySpaceIndex++
            fullBags++
        }
        
        return fullBags
    }

}