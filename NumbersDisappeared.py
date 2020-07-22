class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result=[]
        if nums==None or len(nums)==0:
            return result
        for i in range(len(nums)):
            idx=abs(nums[i])-1
            if nums[idx]>0:
                nums[idx]*=-1
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result
time is O(n)
space is O(1)
