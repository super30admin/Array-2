# Time Complexity : O(n), 
# Space Complexity : o(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums)==0:
            return nums
        result =[]
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index] >0:
                nums[index]*=-1
        for i in range(len(nums)):
            if nums[i] <0:
                nums[i]*-1
            else:
                result.append(i+1)
        return result