# Created by Aashish Adhikari at 9:20 PM 1/7/2021


'''
Time Complexity:
O(n) + O(n)

Space Complexity:
O(1)
'''


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        for idx in range(0,len(nums)):
            index = abs(nums[idx]) - 1

            if nums[index] > 0:

                nums[index] = (-1) * nums[index]

        arr = []

        for idx in range(0,len(nums)):
            if nums[idx] > 0:
                arr.append(idx+1 )

        return arr