# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        num_set=set(nums)
        n=len(nums)
        res=[]
        for i in range(1,n+1): 
            if i not in num_set: 
                res.append(i)
        return res
