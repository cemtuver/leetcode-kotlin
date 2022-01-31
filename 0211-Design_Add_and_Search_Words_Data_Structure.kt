class WordDictionary() {
    
    class Node(var word: String? = null, var children: MutableMap<Char, Node> = mutableMapOf())
    
    private val root = Node()

    fun addWord(word: String) {
        var currentNode = root
        
        word.forEach { char ->
            currentNode = currentNode.children.getOrPut(char) { Node() }
        }
        
        currentNode.word = word
    }

    fun search(word: String): Boolean {
        return search(root, word, word)
    }
    
    private fun search(node: Node, word: String, fullWord: String): Boolean {
        if (node.word != null && word.isEmpty()) return true
        if (word.isEmpty()) return false
        
        val nextChar = word[0]
        val nextWord = word.drop(1)

        return when (nextChar) {
            '.' -> node.children.any { search(it.value, nextWord, fullWord) }
            else -> node.children[word[0]]?.let { search(it, nextWord, fullWord) } ?: false
        }
    }

}

fun main() {
    val wordDictionary = WordDictionary().apply {
        addWord("bad")
        addWord("dad")
        addWord("mad")
    }
    
    val output = listOf(
        wordDictionary.search("pad"),
        wordDictionary.search("bad"),
        wordDictionary.search(".ad"),
        wordDictionary.search("b.."),
    )

    println("Expected: [false, true, true, true]")
    println("Actual  : $output")
}