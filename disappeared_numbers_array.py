"""Explanation: We iterate over the entire array and change the value of every element to negative, that way we know that a specific element
   has been visited. Then we iterate over the array again and see which number has been converted, for any missing number, the index will be
   positive, which means that's the number we need, and hence we append it to the list.
   Time Complexcity: O(n)
   Space Complexcity: O(1)
"""


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        # iterate over the array
        for num in nums:
            # compute new_index, index is always positive
            new_index = abs(num) - 1
            
            # change its magnitude
            if nums[new_index] > 0:
                nums[new_index] *= -1
            
        # 2nd pass to find the result, missing numbers
        for index, num in enumerate(nums, start=1):
            if num > 0:
                result.append(index)
        
        # return answer
        return result