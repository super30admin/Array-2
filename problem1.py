#Time Complexity : O(n) ... where n is the number of elements
#Space Complexity : O(n) ...as this would be a constant value for storing the directions
#Any problem you faced while coding this : no

#Used an approach of marking the correctly occurring numbers with negative sign to keep a track. 

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i, num in enumerate(nums):
            idx = abs(num) - 1
            if(nums[idx] > 0):
                nums[idx] *= -1
        
        for i, num in enumerate(nums):
            if num > 0:
                result.append(i+1)
            else:
                nums[i] *= -1

        return result