// In this solution we need find all disappeared numbers. What we do is have two for loops. In the first pass we mark the indices negative if they are present in the array. In the second pass we read the numbers that are not negative and add it to our liste by incrementing the index with one. 
// Time complexity is O(n) and space complexity is O(1)

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val list = mutableListOf<Int>()
        val n = nums.size

        for (i in 0 ..n-1) {
            var idx = Math.abs(nums[i]) - 1
            if (nums[idx] > 0) {
                nums[idx] *= -1
            }
        }

        for (i in 0 ..n-1) {
            if (nums[i] > 0) {
                list.add(i + 1)
            } else {
                nums[i] *= -1
            }
        }
        return list
    }
}

