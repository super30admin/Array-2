# Time Complexity :O(n) where n is length of nums
# Space Complexity : O(n) for variable n which is a set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. in the condition where I have written "if i not in n" if I will write
# "if i not in set(nums), it threw Time Exceeded error"

class Solution:
    def findDisappearedNumbers(self, nums):
        if len(nums) == 0:
            return []
        n = set(nums)
        return [i for i in range(1, len(nums) + 1) if i not in n]

#Expalination: Here I will iteration my loop from 1 till length of list and if an elemet is not foundi the set of the
# list "nums" then it will be added to the list which is returned directly.