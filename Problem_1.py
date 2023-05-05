"""
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Time Complexity : O(n) where n is the number of elements in the nums
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
1. We will consider array index to determine which numbers from 1 to n are present in nums
2. Loop thorugh the array and take absolute value of the nums[i]
3. Go to the index i and make that value negative indicating index + 1 value is present in given sequence
4. Again in second pass if the value at particular index is positive means index + 1 number is not presnet in the given sequence append that number to the result and return
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        n = len(nums)
        result = []
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1 
        
        for i in range(n):
            if nums[i] > 0:
                result.append(i+1)
        
        return result