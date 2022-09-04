# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums)==0 or nums==None:
            return []
        
        res=[]
        for i in range(len(nums)):
            #Finding the indx if the elemnt. 
            #Example 4 is at 0 so it should be at 4-1=3rd position
            ind=abs(nums[i])-1

            #If the number is positive make it negative
            if nums[ind]>0:
                nums[ind]*=-1

         #Iterate through the elemnts and add i+1 to teh res as the index
         # will be one more       
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        
        return res