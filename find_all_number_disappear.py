"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Trying to come with intuitve soln of
negative indexing

// Your code here along with comments explaining your approach
Algorithm Explanation
BF
    - create a set of the array
    - Iterate from 1 to n and add any element in results array that is not
    present in the set
    - Time - O(n)
    - Space - O(n)

Space optimal
    -Deals with negating the indexing of the array, 
    in case of finding missing numbers within a fixed range, 
    negate nums[nums[i]-1] = - nums[i]. 
    This ensures that the missing element will be at the index which has positive
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #Space suboptimal
        ele = set(nums)
        n = len(nums)
        l = []
        for i in range(1,n+1):
            if i not in ele:
                l.append(i)
        return l

        #Space optimal
        for num in nums:
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
        l  = []
        for i,n in enumerate(nums):
            if n > 0:
               l.append(i+1)
        return l