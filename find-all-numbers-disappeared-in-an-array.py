# Time Complexity: O(n)
# Space Complexity: O(1)

# The code sucessfully ran on Leetcode

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0 or nums == None:
            return []
        
        result = []
        
        for i in range(len(nums)):
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] *= -1
                
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
                
        return result
        