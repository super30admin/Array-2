# TC: O(n)
# SC: O(1)
# LeetCode: Y(https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
# Approach: Loop through the input list and mark elements as present by negating the number at the element index, collect all the numbers that stayed positive
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        disappeared_numbers = []
        
        for index,value in enumerate(nums):
            # mark the number as occured at the index
            if nums[abs(value) - 1] > 0:
                nums[abs(value) - 1] *= -1
             
        # collect the numbers not occured
        for index, value in enumerate(nums):
            if value > 0:
                disappeared_numbers.append(index + 1)
            
        return disappeared_numbers
                
