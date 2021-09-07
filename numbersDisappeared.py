# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        num_range = set([i for i in range(1,n+1)])
        num_set = set(nums)
        out_set = num_range.difference(num_set)
        return list(out_set)
