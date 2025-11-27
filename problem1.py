"""
We check for every index (nums[i] + 1) if the element present at that index is negative,
if its negative, mark it as negative i.e. it is present, and in the second pass, return all elements that remain positive
time is o(n) and space is o(1)
"""

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        n = len(nums)
        for i in range(n):
            index = abs(nums[i]) - 1 #to traverse through the array at each index and
            if nums[index] > 0: #check if number is not negative, make it negative
                nums[index] *= -1

        for i in range(n): #second pass, check if any elem is positive, return that index + 1 as missing number
            if nums[i] > 0:
                res.append(i+1)
        return res

        