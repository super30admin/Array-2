'''
Time Complexity :O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Iteration 1 - Create hashmap with all the keys until the length of the array, iterate through nums and set index to 1
if nums[i] exists in hashmap . The indexes in which nums[i] is not 1 is the index's which are missing.

Sol2: Inplace()
Time Complexity :O(n)
Space Complexity: O(1)  if don't include the resultant array else O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Mark each element by multiplying by -1 by going to nums[abs(nums[i])-1] ie if index is 0 and nums[0] == 3 then go to
index 2 and mark it by multiplying by -1. At the end check index where nums[i]>0 those indexes+1 are the ones missing
'''
class Solution:

    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(0, len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -1 * nums[index]

        l = []
        for i in range(0, len(nums)):

            if nums[i] > 0:
                l.append(i + 1)
        return l

    def findDisappearedNumbersCustom(self, nums: List[int]) -> List[int]:

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