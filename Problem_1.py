"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Changing the input array in order to attain constant space complexity, iterating over each element in the array,
retreiving the value at that index, going to the index at that value and marking it, this way we can keep track which element we have,
at the end, we will end of having missing element represented by some number, unmarked.
"""

# Find all numbers disappeared in an array

class Solution(object):
    def findDisappearedNumbers(self, nums):
        i=0
        while i<len(nums):

            if nums[nums[i]-1]==False or nums[i]==False:
                i+=1
            else:
                temp=nums[i]
                nums[i]=nums[temp-1]
                nums[temp-1]=False
            

        res=[]

        for i in range(0,len(nums)):
            if nums[i]!=False:
                res.append(i+1)
        return res

# without changing the input array completely

class Solution(object):
    def findDisappearedNumbers(self, nums):

        i=0
        for i in range(len(nums)):
            temp=abs(nums[i])-1
            if nums[temp]>0:
                nums[temp]*=-1
            

        res=[]

        for i in range(0,len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res