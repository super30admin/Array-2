#TC => o(n)
#SC => o(1) considering output array as constant
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        ans = []
        for i in range(0,len(nums)):
            if nums[abs(nums[i])-1] >0: 
                nums[abs(nums[i])-1] *= -1
        for i in range(0,len(nums)):
            if nums[i] >0:
                ans.append(i+1) 
        return ans