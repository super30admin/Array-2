# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def findDisappearedNumbers(self, nums):
        result = []
        #Base case
        if nums == None or len(nums) == 0:
            return result
        
        # Make -ve to whole array
        for i in range(len(nums)):
            new_index = abs(nums[i]) - 1
            
            if nums[new_index] > 0:
                nums[new_index] *= -1
        
        # see the missing number through iterate again
        #result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+ 1)
            # Return to original state
            else:
                nums[i] *= -1
        return result
