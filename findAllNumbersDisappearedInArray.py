class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # Time Complexity: O(N)
        # Space Complexity: O(2N) = O(N)
        res = set([i+1 for i in range(len(nums))])
        nums = set(nums)
        for s in nums:
            if s in res:
                res.remove(s)
        return res        
