# S30 Big N Problem #30 {Easy}
# Leetcode #448

# An integer array is given where 1<= a[i] <=n where n is the size of an array , some elements appear twice and other appear once.
# Find all the elements of [1,n[ inclusive that are missing in the array.
# try doing it witout using extra space and in o(n) runtime and assume that returned list does not count as extra space

# Time Complexity : O(n) n= no. of columns in the array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# Traverse through the array. 
# For the index position of the number in the array, make it a negative value 
# Traverse the array again, if a number is positive, the no. of the corresponding index position is not present. 


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        res=[]
        
        for i in range(0,len(nums),1):
            
            temp=abs(nums[i])
            
            nums[temp-1]=abs(nums[temp-1])*-1
            
        for i in range(0,len(nums),1):
            
            if nums[i]>0:
                res.append(i+1)
                
        
        return res
                
            
        
        
        