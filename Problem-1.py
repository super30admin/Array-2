class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        res=[]
        if nums is None or len(nums)==0:
            return res
        for i in range(len(nums)):
            n = abs(nums[i])-1
            if nums[n] > 0:
                nums[n] *=-1

        for i in range(len(nums)):
            if nums[i] >0:
                res.append(i+1)

        return res
