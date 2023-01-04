# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def findDisappearedNumbers(self, nums):
        n=len(nums)
        ans=[]
        for i in range(n):
            k=abs(nums[i])
            nums[k-1]=-1*abs(nums[k-1])
        for i in range(n):
            if(nums[i]>0):
                ans.append(i+1)
            nums[i]=abs(nums[i])
        return(ans)