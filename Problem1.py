# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)


#Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result=[0]*(len(nums)+1)
        for i in nums:
            result[i]+=1
        temp=[]
        for index,val in enumerate(result):
            if index!=0 and val==0:
                temp.append(index)
        return temp