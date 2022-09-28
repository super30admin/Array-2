class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] < 0:
                continue
            else:
                nums[index] *= -1
        print(nums)
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
                
        return result
    
    # Time Complexity: O(n) where n is the size of the array
    # Space Complexity: O(1) because we just used the result array for returning         and computations were done on the nums array itself