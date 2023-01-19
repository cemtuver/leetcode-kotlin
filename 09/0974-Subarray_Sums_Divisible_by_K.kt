class Solution {

    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var numberOfSubarrays = 0
        var sum = 0
        val remainders = IntArray(k) { 0 }

        nums.forEach { num -> 
            sum += num
            var remainder = sum % k

            if (remainder < 0) {
                remainder = (remainder + k) % k
            }

            remainders[remainder] += 1;
        }

        (0 until k).forEach { i -> 
            if (remainders[i] > 1) {
                numberOfSubarrays += (remainders[i] * (remainders[i] - 1)) / 2;
            }
        }

        return remainders[0] + numberOfSubarrays
    }

}