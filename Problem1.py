"""
Implemented using the technique taught in the session, where I first mark the visited indices by making the corresponding elements negative. Then, I retrieve the missing numbers by identifying the indices with positive values.
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        # marking negatives
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            nums[index] = -abs(nums[index])
        
        # retrieving original list with missing indexes
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = abs(nums[i])
            else:
                result.append(i+1)
        return result