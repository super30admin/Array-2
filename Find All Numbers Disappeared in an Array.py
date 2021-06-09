from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        index=0
        result=[]
        for num in nums:
            if nums[abs(num)-1]>0:
                nums[abs(num)-1]=nums[abs(num)-1]*(-1)
        print(nums)
        for i in range(len(nums)):
            if nums[i]<0:
                continue
            else:
                result.append(i+1)
        return result