class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var i = 0
        var mergeInterval = newInterval
        val newIntervals = mutableListOf<IntArray>()
        
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i])
            i++
        }
        
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            mergeInterval = intArrayOf(
                minOf(mergeInterval[0], intervals[i][0]),
                maxOf(mergeInterval[1], intervals[i][1])
            )
            i++
        }
        
        newIntervals.add(mergeInterval)
        
        while (i < intervals.size) {
            newIntervals.add(intervals[i])
            i++
        }
        
        return newIntervals.toTypedArray()
    }
}