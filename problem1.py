'''
Time Complexity :O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Iteration 1 - Create hashmap with all the keys until the length of the array, iterate through nums and set index to 1
if nums[i] exists in hashmap . The indexes in which nums[i] is not 1 is the index's which are missing.
'''
class Solution:

    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        if nums == None or len(nums) == 0:
            return []

        dict1 = {}
        for i in range(1, len(nums) + 1):
            dict1[i] = None

        for i in range(0, len(nums)):
            if dict1[nums[i]] is None:
                dict1[nums[i]] = 1

        mis = []
        for i in range(1, len(dict1) + 1):
            if dict1[i] == None:
                mis.append(i)

        return mis