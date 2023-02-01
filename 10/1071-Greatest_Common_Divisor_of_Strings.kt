class Solution {

    fun gcdOfStrings(str1: String, str2: String): String {
        val str1Str2 = str1 + str2
        val str2Str1 = str2 + str1

        if (str1Str2 != str2Str1) {
            return ""
        }

        var str1Length = str1.length
        var str2Length = str2.length

        while (str1Length != str2Length) {
            when {
                str1Length > str2Length -> str1Length -= str2Length
                else -> str2Length -= str1Length
            }
        }

        return str1.substring(0, str1Length)
    }

}