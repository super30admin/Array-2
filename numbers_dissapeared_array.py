class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        # Iterate over each of the elements in the original array
        for i in range(len(nums)):

            # Treat the value as the new index
            new_index = abs(nums[i]) - 1

            # check if the number has been visited and change the flag value to negative
            if nums[new_index] > 0:
                nums[new_index] *= -1

        result = []

        # Iterate over the numbers from 1 to N and add all those
        # that have positive magnitude in the array
        for i in range(1, len(nums) + 1):
            if nums[i - 1] > 0:
                result.append(i)

        return result


'''
Complexity Analysis

Time Complexity : O(N) N - elements in an array 
Space Complexity : O(1) 
'''