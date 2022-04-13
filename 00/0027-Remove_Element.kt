class Solution {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        var read = 0
        var write = 0
        
        while (read < nums.size) {
            if (nums[read] != `val`) {
                nums[write] = nums[read]
                write++
            }
            
            read++
        }
        
        return write
    }

}