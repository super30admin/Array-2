# Time Complexity : Brute Force: O(n), Optimized: O(n)
# Space Complexity : Brute Force: O(n), Optimized: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        retList = []
        lookup = set()
        for num in nums:
            lookup.add(num)
        
        for i in range(1, len(nums)+1):
            if i not in lookup:
                retList.append(i)
        return retList

class SolutionTwo(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        retList = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = - nums[index]
        
        for i in range(len(nums)):
            if nums[i] > 0:
                retList.append(i + 1)
        return retList

nums = [4,3,2,7,8,2,3,1]
sol1 = Solution()
print(sol1.findDisappearedNumbers(nums))

sol2 = SolutionTwo()
print(sol2.findDisappearedNumbers(nums))