class Solution {

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) return true
        
        val lastIndex = flowerbed.size - 1
        var planted = 0

        for (i in 0 until flowerbed.size) {
            if (
                flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == lastIndex || flowerbed[i + 1] == 0)
            ) {
                flowerbed[i] = 1
                planted++

                if (planted == n) {
                    return true
                }
            }
        }

        return false
    }

}