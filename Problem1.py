# Time Complexity : O(n) where n is the length of nums
# Space Complexity : O(1) since all changes are made in-place
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  Here we know that if there were no missing numbers, each number in the array 
# will belong to a dedicated and unique index (ie, index = (value-1)). We use this property
# to mark the seen positions by negating the number. If any number are left positive, then those indexes
# indicate the missing numbers in the array. (can be found by value = (index+1))

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        res = []
        
        for i in range(len(nums)):
            idealIdx = abs(nums[i])-1
            if nums[idealIdx] > 0:
                nums[idealIdx] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
                
        return res