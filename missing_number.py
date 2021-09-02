# missing_number
# time complexity: O(N)
# space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(0, len(nums)):
            index = abs(nums[i]) - 1
            nums[index] = - abs(nums[index])
        
        res = []
        for j in range(0, len(nums)):
            if nums[j]> 0:
                res.append(j+1)
                
        return res