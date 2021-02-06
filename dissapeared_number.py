// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Since the numbers are in range of [1,N] we make use of array idexes to 
// arrive at the issing elements. We traverse through the array and consider the current element value and mark the array element
// at the 'current value' index -1 as a negative number. Finally the indexes that have positive value have the missing number. 

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        res=[]
        
        for i in range(len(nums)):
            
            if(nums[abs(nums[i])-1]>0):
                nums[abs(nums[i])-1] *= -1
        
        for i in range(len(nums)):
            if(nums[i]>0):
                res.append(i+1)
                
        return(res)
        