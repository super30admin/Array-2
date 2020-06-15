# Time Complexity : O(n)
# Space Complexity : O(1) [I think, but I am not sure if I return the sub-array, then whether the space is constant] 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I am not sure if the solution is optimal in terms of space


# Your code here along with comments explaining your approach
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            index = abs(num)-1
            if nums[index] > 0:
                nums[index] = -1 * nums[index]
        res = []
        for i, num in enumerate(nums):
            if num > 0:res.append(i+1)
        return res