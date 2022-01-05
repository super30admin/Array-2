# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #Optimized
        if not nums: return []
        for i in range(len(nums)):
            if nums[abs(nums[i])-1] > 0: nums[abs(nums[i])-1] *= -1
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result

        #BruteForce
        # count = len(nums)
        # numbers = set([i for i in range(1, len(nums)+1)])
        # numbers2 = set(nums)
        # return list(numbers-numbers2)
        # return(numbers)