"""

Time Complexity : o(2N)
Space Complexity :O(N)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this :no


Approach
Here we are using indexs and temp array mutation to get the result 
because of the mutation we are keeping the space complexity same

basic idea is that we keep track of all the number that we have seen in the array but,
converting the number at the index of the number found 
as negative after we are do with one pass

on the second pass we just see if a number is negative of not if now then that index or nunmber is missing

"""


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        result = list()

        for i in range(len(nums)):
            index = abs(nums[i]) -1
            if nums[index] > 0:
                nums[index] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] *= -1
        return result

        
        