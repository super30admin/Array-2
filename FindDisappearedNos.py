class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        '''// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
        result=[]
        
        #if list is empty, return empty list
        if len(nums)==0:
            return result
        
        #MAKING THE ELEMENTS AT THEIR CORRESPONDING INDICES -VE 
        for i in range(len(nums)):
            ind=abs(nums[i])-1
            if nums[ind] > 0:
                nums[ind] *= -1
        #CHECK FOR THE +VE ELEMENTS AND APPEND
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        
        return result
            
        
