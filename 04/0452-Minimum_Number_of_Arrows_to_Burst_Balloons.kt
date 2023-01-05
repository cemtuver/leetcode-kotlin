class Solution {

    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }

        var numberOfArrows = 1
        var currentEnd = points[0][1]

        for (i in 1 until points.size) {
            if (points[i][0] > currentEnd) {
                numberOfArrows++
                currentEnd = points[i][1]
            }
        }

        return numberOfArrows
    }

}