# Time Complexity : O(n)
# Space Complexity: O(1)
# Works on leetcode: Yes
# Approach: For each number i in nums,we mark the number that i points as negative.Then we filter the list, 
# get all the indexes who points to a positive number
class Solution:
	# Function to find the disappearing numbers
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            index = abs(nums[i])-1
            nums[index] = -abs(nums[index])
        return [(i+1) for i in range(len(nums)) if nums[i]>0 ]