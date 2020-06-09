from typing import List

"""

    Student :  Shahreen Shahjahan Psyche
    Time Complexity : O(N)
    Space Complexity : O(1)

    This code ran successfully for all the test cases of Leetcode

"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # edge case
        if not nums:
            return []
        
        # initilizing the output array with the values 1 through n
        res = [i+1 for i in range(len(nums))]
        
        pointer = 0
        
        # the index of res's value is index+1. So, whenever I am getting a nums[i]
        # value, I am going to that index of res and making that to -1 . I am doing
        # this to eliminate all the values that are present in nums
        for i in range(len(nums)):
            if nums[i] == res[nums[i]-1]:
                res[nums[i]-1] = -1
        
        # In this loop I am swapping the non -1 value to the beggining of the output array
        # and keeping also track of these values total number
        for i in range(len(res)):
            if res[i] != -1:
                res[i], res[pointer] = res[pointer], res[i]
                pointer += 1

        if pointer == -1:
            return []
        else:
        # I am popping all the values that comes after the total number of the non -1
        # values in res array
            size = len(res) - pointer
            for _ in range(size):
                res.pop()
        
        
        return res