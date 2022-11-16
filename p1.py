# Array-2
# TC : O(N)
# SC : O(1)
## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # using no extra space:
        res = []
        for i in range(len(nums)):
            ind = abs(nums[i]) - 1
            if nums[ind]>0:
                nums[ind] = nums[ind] * -1
        for j in range(len(nums)):
            if nums[j] > 0:
                res.append(j+1)
        return res
        
        # # using O(1) space
        # k  = set(nums)
        # res = []
        # l = len(nums)
        # while l:
        #     if l not in k: # searching in set takes O(1), where as in list takes O(n)
        #         res.append(l)
        #     l -= 1
        # return res
    
            
        