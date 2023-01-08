class Solution {

    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size == 1) return 1

        var maxPoints = 0

        for (i in 0 until points.size) {
            var slopes = mutableMapOf<Float, Int>()

            for (j in i + 1 until points.size) {
                val slope = when {
                    points[i][1] == points[j][1] -> 0f // to prevent -0.0
                    points[i][0] == points[j][0] -> Float.MAX_VALUE // to prevent -Infinity
                    else -> (points[i][1] - points[j][1]).toFloat() / (points[i][0] - points[j][0]).toFloat()
                }
                
                val currentPoints = slopes.getOrDefault(slope, 1) + 1

                slopes[slope] = currentPoints
                maxPoints = maxOf(maxPoints, currentPoints)
            }
        }

        return maxPoints

    }
}