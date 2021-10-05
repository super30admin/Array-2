# Time Complexity : O(n)
# Space Complexity : O(1) extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


#  Your code here along with comments explaining your approach
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        s = set()

        for n in nums:
            s.add(n)

        for i in range(1, len(nums) + 1):
            if i in s:
                s.remove(i)
            else:
                s.add(i)

        return s