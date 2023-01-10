class Solution {

    fun wordPattern(pattern: String, s: String): Boolean {
        val patternMap = mutableMapOf<Char, String>()
        val strings = s.split(" ")

        if (pattern.length != strings.size) return false

        for (i in 0 until pattern.length) {
            val char = pattern[i]
            val string = strings[i]

            if (patternMap.getOrDefault(char, string) != string) {
                return false
            }

            patternMap[char] = string
        }
        
        return patternMap.values.toSet().size == patternMap.size
    }

}