"""
Time Complexity: O(N)
Space Complexity: O(1)
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        ans = []
        for x in nums: 
            ind = abs(x)-1
            if nums[ind] < 0:
                continue
            nums[ind] = nums[ind] * -1

        return [i+1 for i,n in enumerate(nums) if n > 0]
