# Time Complexity : O(n) we are traversing through the entire array
#Space Complexity : O(1)   - we didn't use any extra space, and we don't count the output array as extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 



class Solution:
    def findDisappearedNumbers(self, nums) :
        
        result = []
        
        for i in range(len(nums)):       #traverse through the array and make the value in the index (current value) as negative, that means it is already present
            idx = abs(nums[i]) - 1
            if nums[idx]>0:
                nums[idx]*=-1 
            
        for i in range(len(nums)):   #while passing the second time, if a number is greater than zero, that means the (number+1) is not found, then add it to the resultant value
    
            if nums[i]>0: 
                result.append(i + 1) 
                
            else: 
                
                nums[i]*=-1    #else, retain the original value
        
        return result