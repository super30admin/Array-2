from typing import List
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in nums:
            ind=abs(i)-1
            if(nums[ind]>=0):
                #if the number is positive then convert to negative, This is making a mark that the element has occured 
                nums[ind]=-nums[ind]
        output=[]
        for i in range(len(nums)):
            if(nums[i]>=0):
                output.append(i+1)
        #print(output)
        return output