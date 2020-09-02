"""
448. Find All Numbers Disappeared in an Array

Time = O(n); n = number elements in array
space = O(1); constant space
Successfully excecuted on leetcode


Approach - 
1. Use the original array to keep track of the numbers visited. All number given are positive
2. For every number visited we mark the presence by negating the number at the index equal to the current number.
3. If the number is already negative we do nothing, return the indices where there are still positive numbers.
"""

class Disappeared:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            temp = abs(nums[i]) - 1 # (number-1 cause of 0 indexing)
            if nums[temp] > 0:
                nums[temp] *= -1
        
        res = []
        for i,n in enumerate(nums):
            if n > 0:
                res.append(i+1)
        
        return res
    
