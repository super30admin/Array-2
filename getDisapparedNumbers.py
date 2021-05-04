"""
Intuition: Since the array elements start from 1-N, make the index at A[index]-1 as negative.
This will indicate that the number is already browsed.
Loop through the array again and indices of all positive numbers.

Note: Since no major change has been made on the array, the original array can be recovered easily.
#####################################################################
Time Complexity : O(N) where N = number of elements
Space Complexity : O(1) 
#####################################################################
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for index in range(len(nums)):
            num = nums[index]
            newIndex = abs(num)  - 1
            if nums[newIndex] > 0:
                nums[newIndex] = -1 * nums[newIndex]
        
        for index in range(len(nums)):
            if nums[index] >0:
                result.append(index+1)
        return result
                