# TC : O(N) - N is the length of the input array
# SC : O(1)

# Approach - Refer to the comments
 
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # 1st traversal, turn the numbers in the index as -ve which were seen
        result = []

        for num in nums:
            if nums[abs(num)-1] < 0:
                continue
            nums[abs(num)-1] *= -1
        # 2nd traversal, find the index where numbers are > 0, that means those numbers 
        # are not seen 

        for index, num in enumerate(nums):
            if num > 0:
                result.append(index + 1)
        
        return result
        

 