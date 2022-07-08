# Time Complexity: O(n) -- Since we are parsing the array twice, one for making the indexes visited and other to check which one's are positive index.
# Space Complexity: O(1) -- result array is what is expected from them and we arent using any additional space, hence it is constant space complexity.
# Did this code successfully run on Leetcode : Yes
# Code:
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        result = []
        
        for i in range(n):
            if nums[i] < 0:         # Case when the index is already addressed, so nums[i] will be negative
                index = (nums[i] * -1) - 1
            else:
                index = nums[i] - 1 
            if nums[index] > 0:   # Case when the index is already made negative and repeat occurence found 
                nums[index] = nums[index] * -1
                
        
        for i in range(n):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] = nums[i] * -1   # Retain the original array.
        
        
        return result

# Approach: We are given an array of n integers with values ranging from 1-n. The indexes range will be from 0 to n-1. So if we encounter value of n, the index 
#           wont be found hence when we traverse the array, we do nums[i] - 1 making the number negative at the position. Example if nums[i] == 8, then we mark the 7th index 
#           as negative meaning we have found value 8. Like wise, we do for all the elements. After parsing through the array, we again parse through the array to check which 
#           indexes have positive values. If the value at an index is positive, then we can say that index + 1 value was not found in the array.