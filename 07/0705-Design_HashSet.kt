class MyHashSet() {

    private val size = 1000
    
    private val items = Array(size) { mutableListOf<Int>() }
    
    private fun getBucketIndex(key: Int): Int {
        return key % size
    }
    
    fun add(key: Int) {
        if (!contains(key)) {
            items[getBucketIndex(key)].add(key)
        }
    }

    fun remove(key: Int) {
        items[getBucketIndex(key)].remove(key)
    }

    fun contains(key: Int): Boolean {
        return items[getBucketIndex(key)].contains(key)
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */