class LFUCache(private val capacity: Int) {

    private data class Item(var value: Int, var frequency: Int)

    private var minFrequency = 0
    private val items = hashMapOf<Int, Item>()
    private val frequencySets = hashMapOf<Int, MutableSet<Int>>()

    private fun getItem(key: Int): Item? {
        val item = items.get(key) ?: return null
        val frequencySet = frequencySets.get(item.frequency)!!
        
        frequencySet.remove(key)

        if (minFrequency == item.frequency && frequencySet.isEmpty()) {
            minFrequency += 1
        }

        item.frequency += 1
        frequencySets.getOrPut(item.frequency) {  mutableSetOf() }.add(key)

        return item
    }


    fun get(key: Int): Int {
        return getItem(key)?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) return

        val item = getItem(key)

        if (item != null) {
            item.value = value
        } else {
            val newItem = Item(value, 1)

            if (items.size == capacity) {
                val frequencySet = frequencySets.get(minFrequency)!!
                val keyToRemove = frequencySet.first()

                frequencySet.remove(keyToRemove)
                items.remove(keyToRemove)
            }

            minFrequency = 1
            items[key] = newItem
            frequencySets.getOrPut(1) { mutableSetOf() }.add(key)
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * var obj = LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */