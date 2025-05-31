# Problem #31 Find All Numbers Disappeared in an Array
#LeetCode #448

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# As numbers in array can only be from 1 to n.
# Map the value at the index nums[val] to negative 
# check for missing negative index gives us result

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []
        for i in range(n):
            idx = abs(nums[i])-1
            if nums[idx] > 0:
                nums[idx] = - nums[idx] 

        for i in range(n):
            if nums[i] > 0:
                res.append(i+1)
            else:
                # retain the original array state
                nums[i] = abs(nums[i])
        return res