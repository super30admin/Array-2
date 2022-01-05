# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        result = []
        # Iterate through the element and go to the index whose index is the value of the element  
        # negate the corresponding element at that index.
        
        for i in range(len(nums)):
            index = abs(nums[i]) - 1 
            if(nums[index] > 0):
                nums[index] = nums[index] * -1
                
        # add all the positive values into the result indicating they are not present
        for i in range(len(nums)):
            if (nums[i] > 0 ):
                result.append(i + 1)
        
        return result