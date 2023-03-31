# Time Complexity : O(n) because we are iterating through the array twice separately
# Space Complexity : O(1) because we are not using any extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code  we are using the fact that the array contains numbers from 1 to n and we are using the index 
of the array to mark the number as visited. We are iterating through the array and marking the number at the 
index as visited by multiplying it by -1. Then we are iterating through the array again and if the number is 
positive then we are appending it to the result array. We are doing this because the number at the index is 
not visited and hence it is missing.
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []

        result = []

        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] *= -1

        return result