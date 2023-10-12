# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        hashMap = {i : 0 for i in range(1, len(nums)+1)}
        res = []
        for i in nums:
            hashMap[i] += 1
        for k,v in hashMap.items():
            if v == 0:
                res.append(k)
        return res