# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes  
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach: This code finds all the numbers missing from an array of size n where elements are in the range 1 to n. It does this by iterating through the array and marking visited numbers as negative at their corresponding index (abs(nums[i]) - 1). Finally, it collects indices that remain positive, meaning their corresponding numbers never appeared, and returns them as the missing numbers.


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []

        for i in range(n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
        
        return result
