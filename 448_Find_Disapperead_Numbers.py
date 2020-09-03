# Leetcode link : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
# Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
    Brute force approach => Extra O(n) space to maintain hashset of values that we come across or maintain a counter array and keep populating the values. Once reached end of array, traverse through counter array or hashset to check missing values.
    
    O(1) space solution => Traverse the array. Take the element at current index and go and negate the element present at the index = current element which shows that number is present. Traverse through the array again and the one with non-negative index are the missing numbers
'''


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # edge case
        if not nums or len(nums) == 0:
            return []
        
        # intialize output array
        missing = []
        
        # traverse the input array
        for i in range(len(nums)):
            # get absolute value of current element as it might have been negated by a previous element index
            curr = abs(nums[i])
            
            # if current element should exist in the range 1 to n inclusive then negate the element at that index
            if curr-1 < len(nums) and nums[curr-1] > 0:
                nums[curr-1] *= -1
        # check for negative elements and add to output if its not negative as thats the missing index element
        for i in range(len(nums)):
            if nums[i] > 0:
                missing.append(i+1)
        return missing
        