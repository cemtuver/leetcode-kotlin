class Solution {

    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        if (n == 2) return 1

        var first = 0
        var second = 1
        var third = 1

        repeat(n - 2) {
            val tmpThird = third

            third = third + first + second
            first = second
            second = tmpThird
        }

        return third
    }

}