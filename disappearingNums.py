'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

// Your code here along with comments explaining your approach
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # approach 1 : Brute force - convert list to a set and iterate over it
        # find all missing numbers using `x in set` operation
        # TC O(n) SC O(n)
        r = []
        s = set(nums) # O(n) time and O(n) space to do this conversion
        l = 0
        while l < len(nums): # O(n) for this loop
            if l+1 not in s: # O(1) for set lookups
                r.append(l+1)
            l+=1    
        return r

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        '''
        approach 2: In-place modification of array
        Use nums[i] to find nums[nums[i]-1] and set it to -ve
        then find all non-negative nums to return missing numbers
        TC O(n) 2 passes
        SC O(1)
        ''' 
        r = []
        for i, n in enumerate(nums):
            if nums[abs(n)-1] > 0:
                nums[abs(n)-1] = - nums[abs(n)-1]
        print(nums)
        
        for i, n in enumerate(nums):
            if n < 0:
                nums[i] = - n
            elif n > 0:
                r.append(i+1)
        return r