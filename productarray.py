"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        numslength = len(nums)
        result = []
        
        for i in range(numslength):
            currNum = abs(nums[i])
            
            if nums[currNum -1] > 0:
                nums[currNum -1] *= -1
        
        for i in range(numslength):
            if nums[i] < 0:
                nums[i] *= -1
                
            else:
                result.append(i+1)

        return result
        
