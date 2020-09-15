# Time complexity: O(N)
# Space complexity: O(1)
# Did it compile on leetcode? : Yes
# Difficulties: No
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            nums[abs(nums[i]) - 1] = -1 * abs(nums[abs(nums[i]) - 1])
        
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        
        return result