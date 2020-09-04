// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        arr=[]
        for i in nums: # for every number , mark its corresponding index
                index=abs(i)-1 
                if nums[index]>0:
                    nums[index]*=-1
        for i in  range(len(nums)): # the ones which are positive give the result
            if nums[i]>0:
                arr.append(i+1)
        return arr
        