
#Time Complexity : O(N)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # Step 1: Mark the indices
        for num in nums:
            index = abs(num) - 1  
            if nums[index] > 0:
                nums[index] = -nums[index]  

        # Step 2: Collect indices that were never visited
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)  # i+1 was missing

        return result
    
