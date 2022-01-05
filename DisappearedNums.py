# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''Because of the constraints we can use the numbers themselves as markers. 
Those numbers that are not negative. The index at which they are present. 
Those indices are our answer.'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for i in range(len(nums)):
            idx = abs(nums[i]) % len(nums)
            nums[idx] = -abs(nums[idx])
        
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                if i == 0:
                    result.append(len(nums))
                else:
                    result.append(i)
        
        return result