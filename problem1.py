'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if(nums[index] > 0):
                nums[index] *= -1

        for i in range(1, len(nums) + 1):
            if nums[i - 1] > 0:
                result.append(i)
        
        return result