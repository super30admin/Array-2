# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #Assign the required variables
        n = len(nums)
        result=[]
        #Firt Iteration through nums to mark -ve
        for i in range(0,n):
            #num stores the number at index i
            num=nums[i]
            #idx stores the corresponding index of num
            #Here taking absolute value as it might have changed -ve in the previous iteration
            idx=abs(num)-1 
            #Checking if value in the corresponding index of num is positive or not. if not mark -ve
            if(nums[idx]>0):
                nums[idx]*=-1
        #Second iteration to change the negative numbers as positive numbers
        for i in range(0,n):
            if(nums[i]<0):
                nums[i]*=-1
            #Numbers that are already positive are missing numbers
            else:
                result.append(i+1)
        return result




        