#448. Find All Numbers Disappeared in an Array
#Time Complexity :O(n)
#Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes 
#Any problem you faced while coding this : -
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums  == [] or len(nums) < 1:
            return []
        res = []
        for i in range(len(nums)):
            abs_val = abs(nums[i])-1
            if nums[abs_val] > 0:
                nums[abs_val] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res