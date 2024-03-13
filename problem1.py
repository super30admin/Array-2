# time complexity is O(N) and space complexity is O(1)
class Solution:
    def findMissingNumbers(self, nums):
        for num in nums:
            idx = abs(num)-1
            nums[idx] = abs(nums[idx])*(-1)
            
        res = []
        for i, num in enumerate(nums):
            if num>0:
                res.append(i+1)
        return res
                
            
            
        