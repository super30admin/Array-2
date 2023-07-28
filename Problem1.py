'''
Problem: Find All Numbers Disappeared in an Array
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        iterate over the array and change the element on that index to negative
        again iterate and the indexes at which numbers are positive
        put them into result
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []

        for i in range(n):
            idx = abs(nums[i])-1
            if nums[idx]<0:
                continue
            else:
                nums[idx]*= -1
    
        
        for i in range(n):
            if nums[i] < 0:
                continue
            else:
                result.append(i+1)
        return result