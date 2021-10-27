class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # return list(set([num for num in range(1,len(nums)+1)]) - set(nums))
        final = []
        for i,val in enumerate(nums):
            if nums[abs(val) - 1] > 0:  
                nums[abs(val) - 1] = nums[abs(val) - 1] * -1
        for i,val in enumerate(nums):
            if val > 0:
                final.append(i+1)
        return final