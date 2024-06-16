"""
Array-2

Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is multiplying with -ve number i.e., we'll iterate over the array and store it is an
index and multiply -1 to the value present at that index. Once the iteration is done we'll again iterate
and see which ever indices doesn't have -ve's we'll just add those indices+1 to the result.
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums or len(nums) == 0:
            return []

        for num in nums:
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        missing_nums = []
        
        for i in range(len(nums)):
            if nums[i] > 0:
                missing_nums.append(i+1)
            else:
                nums[i] *= -1

        return missing_nums 
        