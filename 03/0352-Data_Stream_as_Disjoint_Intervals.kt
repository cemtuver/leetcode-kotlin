class SummaryRanges() {

    private val valueSet = sortedSetOf<Int>()

    fun addNum(value: Int) {
        valueSet.add(value)
    }

    fun getIntervals(): Array<IntArray> {
        val values = valueSet.toList()
        val intervalList = mutableListOf<List<Int>>()
        var start = values[0]
        var end = values[0]

        for (i in 1 until values.size) {
            val value = values[i]

            if (value - end == 1) {
                end = value
            } else {
                intervalList.add(listOf(start, end))
                start = value
                end = value
            }
        }

        intervalList.add(listOf(start, end))

        return intervalList.map { it.toIntArray() }.toTypedArray()
    }

}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * var obj = SummaryRanges()
 * obj.addNum(value)
 * var param_2 = obj.getIntervals()
 */