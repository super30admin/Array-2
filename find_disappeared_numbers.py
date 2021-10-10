#TC = O(n)
#SC = O(1)
#Compiled and run on Leetcode

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        res = []

        for i in nums:
            idx = abs(i) - 1 #find abs diff of indexes

            if (nums[idx] > 0): #if num at that idx is positive, make it negative - ENCODING
                nums[idx] *= -1

        for i in range(len(nums)): # iterate thr loop to find positive numbers left out in array. This means those numbers were dispappeared
            if (nums[i] > 0):
                res.append(i + 1)

        return res