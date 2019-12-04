class Solution(object):
    def maxmin(self,nums):
        if not nums:
            return None
        minn=nums[0]
        maxx=nums[0]
        for i in range(1,len(nums),2):
            if i==len(nums)-1:
                minn=min(minn,nums[i])
                maxx=max(maxx,nums[i])
            elif nums[i]>nums[i+1]:
                maxx=max(nums[i],maxx)
            elif nums[i]<nums[i+1]:
                minn=min(nums[i],minn)
        return maxx, minn
obj = Solution()
nums = [-14,2,0,4,5,6,-1,14]
print(obj.maxmin(nums))

