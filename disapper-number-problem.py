class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(0,len(nums)-1):
            idx = nums[i]-1
            if nums[idx] > 0:
                nums[idx] *= -1
        
        for i in range(0,len(nums)-1):
            if nums[i] > 0:
                result.append(i+1)
        
        return result
            