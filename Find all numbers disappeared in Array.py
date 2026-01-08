class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n=len(nums)
        result=[]
        for i in range(len(nums)):
            if nums[abs(nums[i])-1]>0:
                nums[abs(nums[i])-1]=nums[abs(nums[i])-1]*-1
        
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
            else:
                nums[i]=nums[i]*-1
        return result