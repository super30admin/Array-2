# Time Complexity : O(n)
# Space Complexity : O(1) (excluding output)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use index marking.
# Iterate through the array and treat each value as an index (value - 1).
# Mark the corresponding index as negative to indicate the number exists.
# After marking, iterate again and collect indices that remain positive,
# as they represent the missing numbers.




class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        idx = -1
        res = []
        for i in nums:
            idx = abs(i)
            if nums[idx - 1] > 0:
                nums[idx - 1] = nums[idx - 1] * -1 
        
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
        return res