'''
Time Complexity: O(n)
Space Complexity: O(1)
Run on Leetcode: YES
'''
class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        output = []
        for index in range(len(nums)):
            nums[abs(nums[index])-1] = 0 - abs(nums[abs(nums[index])-1])
        for index in range(len(nums)):
            if nums[index] > 0:
                output.append(index+1)
        return output