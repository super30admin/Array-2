# Time complexity: O(n) where n is the length of the array.
# Space complexity: O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0: return []
        result =[]
        for i in range(len(nums)):
            index = abs(nums[i]) - 1        
            if nums[index] > 0:
                nums[index] = nums[index] * -1  # Index + 1 value is found.
        
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = nums[i] * -1          # Reverting the changes to the array.
            else:
                result.append(i + 1)            # If index value is +, index + 1 is the missing number.
                
        return result