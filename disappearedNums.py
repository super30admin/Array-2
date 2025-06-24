# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

# Convert values to index and mark as visited by negative.
# All positions with positive are not visited are missing number
# Convert index back to number 

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            index = abs(num) - 1 # Convert value to index
            if nums[index] > 0:
                nums[index] *= -1 #  Mark as visited by making it negative
            
            result = []
        for i in range(len(nums)):
            if nums[i] >0:
                result.append(i+1) # Convert index back to number
        return result
        