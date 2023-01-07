class Solution {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var remainingGas = 0
        var minimumRemainingGas = Int.MAX_VALUE
        var stationIndexWithMinumumGas = 0        

        for (i in 0 until gas.size) {
            val gain = gas[i] - cost[i]
            remainingGas += gain

            if (remainingGas < minimumRemainingGas) {
                minimumRemainingGas = remainingGas
                stationIndexWithMinumumGas = i
            }
        }

        return when {
            remainingGas < 0 -> -1
            else -> (stationIndexWithMinumumGas + 1) % gas.size
        }        
    }

}