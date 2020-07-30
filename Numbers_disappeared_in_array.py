#Time Complexity : O(n)

#Space Complexity : O(1) 

#Did this code successfully run on Leetcode : Yes

#Any problem you faced while coding this :None

# =============================================================================
# Solution: traverse the array take the element and make the element at that index to be negative if it is positive.
#Now again traverse the array elements which are positive in the array return their index with +1
# =============================================================================


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res= []
        for i in range(len(nums)):
            if nums[abs(nums[i])-1] > 0:
                nums[abs(nums[i])-1] *= -1
        for i in range(1,len(nums)+1):
            if nums[i-1] >0:
                res.append(i)
        return res
                
                
                
            
       
        
            
            