#https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
#time-o(n)
#space-o(n)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result=[]
        a=set(nums)
        for num in range(1, len(nums) + 1):
            if num not in a:
                result.append(num)        
        return result  
            