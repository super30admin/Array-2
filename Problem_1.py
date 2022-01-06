# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed approach from class
# // Your code here along with comments explaining your approach
# Finding number Disappeared in an array 
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        if nums == None: return result
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] *= -1
        return result
        
        