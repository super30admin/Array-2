    # Time Complexity : O(n)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            idx = abs(nums[i]) -1
            if nums[idx] > 0:
                nums[idx] = nums[idx]* -1
        
        result=[]
        
        for i in range(1, len(nums)+1):
            if nums[i-1] >0:
                result.append(i)
        return result




    # using HashTable
    # Time Complexity : O(n)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution2(object):
    def findDisappearedNumbersUsingHash(self, nums):
        dic = {}
        n = len(nums)
        
        for i in range(n):
            dic[nums[i]] = nums[i]
        lst = []  
        
        for i in range(1, n+1):
            if i not in dic:
                lst.append(i)
        return lst