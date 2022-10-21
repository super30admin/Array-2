class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        """
        Approach - Temp state change of the values by multiplying it to -1 in the array
        Time Complexity: O(n), n is no of elements in the list
        Space Complexity: O(1)
        """
        if len(nums) == 0: return 0
        
        res = []

        # First Pass: temp state change to negative number
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
                
        # Second pass: check for positive numbers
        for i in range(len(nums)):
            if nums[i] > 0 :
                res.append(i + 1)
            else:
                nums[i] *= -1
              
            
        return res 