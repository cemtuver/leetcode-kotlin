class Solution {

    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val concatenatedWords = mutableListOf<String>()
        val wordsSet = words.toHashSet()

        words.forEach { word ->
            val concatenatedPositions = BooleanArray(word.length + 1) { false }
            concatenatedPositions[0] = true

            for (i in 0 until word.length) {
                if (!concatenatedPositions[i]) continue

                for (j in (i + 1)..word.length) {
                    if (j - i < word.length && wordsSet.contains(word.substring(i, j))) {
                        concatenatedPositions[j] = true
                    }
                }
            }

            if (concatenatedPositions[word.length]) {
                concatenatedWords.add(word)
            }
        }

        return concatenatedWords        
    }

}