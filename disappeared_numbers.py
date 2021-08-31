# Did this code successfully run on Leetcode : YES

# TC: O(n)
# SC: O(1)

# approach
# flip index wherever index found
# if index is still positive, that element is missing

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result