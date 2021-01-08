# Created by Aashish Adhikari at 8:35 PM 1/7/2021

'''
Time Complexity:
O(n) + O(n)

Space Complexity:
Since need to store all ~n elements in the set in the worst case, O(n)
'''

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        hs = set()

        for idx in range(0, len(nums)):
            if nums[idx] not in hs:
                hs.add(nums[idx])

        arr = []

        for idx in range(1, len(nums) + 1):

            if idx not in hs:
                arr.append(idx)

        return arr
