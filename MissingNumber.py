class Solution:
    def findDisappearedNumbers(self, nums):
        res=[]
        for i in range(len(nums)):
            if nums[abs(nums[i])-1] >0:
                nums[abs(nums[i])-1]*=-1
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res
        