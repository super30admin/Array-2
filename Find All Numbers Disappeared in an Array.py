# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(len(nums)):
            idx = abs(nums[i])-1
            if nums[idx] > 0:
                nums[idx] *= -1
                
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
            else:
                nums[i] *= -1 #redo changes for original matrix before returning
            
        return res
