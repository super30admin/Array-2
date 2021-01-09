# Problem 1: Find disappeared number in an array -> Time complexicity: O(n), Space Complexicity: O(1)

class Solution:

    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
    
        result = []; n = len(nums)
        if n == 0: return result
        else:
            for i in range(n):
                indx = abs(nums[i]) - 1
                if nums[indx] > 0 : nums[indx] *= -1
            for i in range(n):
                if nums[i] > 0:
                    result.append(i+1)
        return result
        
   
