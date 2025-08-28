// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : line 11
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        //between 1 to n
        //So we can iterate over array values and jump to that index value and theh mark it as read by changing it to -ive
        val res = mutableListOf<Int>()
        for (n in nums) {
            val idx = Math.abs(n) - 1
            if (nums[idx] > 0) {
                nums[idx] *= -1
            }
        }
        for (i in nums.indices) {
            val v = nums[i]
            if (v > 0) {
                res.add(i + 1)
            }
        }
        return res
    }
}