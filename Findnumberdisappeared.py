# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to create a hashmap and note all the numbers as per index, whichever is present in nums increment to 1 and return 
# the numbers that are count 0.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        d={}
        for i in range(1,len(nums)+1):
            d[i]=0
            
        print(d)
        for i in nums:    
            if i in d:
                d[i]=d[i]+1
            else:
                d[i]=1
        res=[]
        for i in d:
            if d[i]==0:
                res.append(i)
        return res
