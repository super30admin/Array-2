# problem1 

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        final_arr = []
        for num in nums:
            idx = abs(num)-1
            if nums[idx] > 0:
                nums[idx]= nums[idx]*(-1)
        for i in range(len(nums)):
            if nums[i] > 0:
                final_arr.append(i+1)
        return final_arr