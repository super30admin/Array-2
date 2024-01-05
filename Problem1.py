'''

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach
Going thru the array once I mark in the particular index if its present by making the element negative.
In the next traversal I return the non-negative elements

'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []

        for i in range(len(nums)):
            if nums[abs(nums[i])-1] > 0:
                nums[abs(nums[i])-1] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)

        return res