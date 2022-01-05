# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        
        for i in range(len(nums)):
            index = abs(nums[i]) -1
            
            if(nums[index] > 0):
                nums[index] *= -1
                
        for i in range(len(nums)):
            if(nums[i]>0):
                result.append(i+1)
            else:
                nums[i] *= -1
                
        return result