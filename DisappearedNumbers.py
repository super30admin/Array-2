# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        #change all the positions of numbers found to negative
        for x in range(len(nums)):
            if nums[abs(nums[x])-1] > 0:
                nums[abs(nums[x])-1]=nums[abs(nums[x])-1]*-1
                
        ans=[]
        
        # the positive numbers are missing values
        for x in range(len(nums)):
            if nums[x] > 0:
                ans.append(x+1)
        
        return ans