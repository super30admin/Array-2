class Solution:
    def findDisappearedNumbers(self, nums: List[int]) :
        # TC: O(n) , SC: O(n)
        max_nums = len(nums)
        for i in range(max_nums):
            nums[abs(nums[i]) - 1] = 0 - abs(nums[abs(nums[i]) - 1])
        
        result = []  
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        
        return result