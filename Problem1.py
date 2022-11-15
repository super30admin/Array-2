#Time Complexity: O(n)
#Space Complexity: O(1)

#Accepted on Leetcode

#Approach
# Iterate through Arr, for each element 'x' mark the corresponding 'x+1' index as negative (if x in negative take it's absolute value)
# At the end whichever indices are positive - they haven't been hit, meaning we know which elements are not present


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for x in nums:
            elemIndex = abs(x) - 1
            if nums[elemIndex] > 0:
                nums[elemIndex] = 0-nums[elemIndex]
        soln = []
        for i,x in enumerate(nums):
            if x > 0:
                soln.append(i+1)

        return soln


            


# TC 1 = [1,1]
# n = 2
# x = 1, HS = {1}
# x = 1, HS = {1}
# for i 1 to 2 inclusive
# i = 1, soln = []
# i = 2, soln = [2]