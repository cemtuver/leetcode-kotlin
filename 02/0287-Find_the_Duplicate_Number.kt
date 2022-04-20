class Solution {
    
    fun findDuplicate(nums: IntArray): Int {
        var duplicateIndex = 0
        
        for (i in 0 until nums.size) {
            val num = Math.abs(nums[i])
            
            if (nums[num] < 0) {
                duplicateIndex = i
                break
            }
            
            nums[num] = -1 * nums[num]
        }
        
        for (i in 0 until nums.size) {
            nums[i] = Math.abs(nums[i])
        }
        
        
        return nums[duplicateIndex]
    }

}
