# Problem 1: Find All Numbers Disappeared in an Array https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Explanation:
    # - We can solve this problem by using the input array itself to mark the presence of numbers.
    # - We iterate through the array and for each number, we mark the corresponding index as negative.
    # - Finally, we collect the indices that are still positive, which represent the numbers that are missing from the array.   

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
            
        result = []
        
        for i in range(len(nums)):
            idx = abs(nums[i]) -1
            if nums[idx] > 0:
                nums[idx] = nums[idx]*(-1)

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] = abs(nums[i])

        return result