# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

# In this problem as the range started from 1 so index is used to find the missing number. If any index is positive means that number was missing from the array. So to find the missing number we are adding 1 to the index to get the number.
# Time Complexity- O(n) Space Complexity- O(1)

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        n = len(nums)

        for i in range(n):
            # index starts from 0, so we are finding the index of the number by subracting 1 because nums is starting from 1. and the absolute condition is to hangle the duplicate numbers
            index = abs(nums[i]) - 1
            # if the index is positive make it negative if it's already negative then don't multiply because it will make it positive, where positive stands for missing number 
            if nums[index] > 0:
                nums[index] *= -1

        result = []
        for i in range(n):
            # as we marked the number to negative so missing number is positive checking that condition
            if nums[i] > 0:
                # if index is found then to get the number add 1 and append into the result set
                result.append(i + 1)
        return result

solution =Solution()
print(solution.findDisappearedNumbers([4,3,2,7,8,2,3,1]))      

