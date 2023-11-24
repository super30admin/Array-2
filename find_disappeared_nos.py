class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res=[]
        for i in range(0,len(nums)):
            k=abs(nums[i])
            if nums[k-1]>0:
                nums[k-1]=(-1)*nums[k-1]
        print(nums)
        for i in range(0,len(nums)):
            if nums[i]>=0:
                res.append(i+1)

        print(res)
        return res
        