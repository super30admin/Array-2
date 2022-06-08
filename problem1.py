# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
#

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        result = []
        for i in range(1, len(nums)+1):
            x = nums[i-1]
            if x < 0:
                x = nums[i-1] * -1
            if nums[x-1] > 0:
                nums[x-1] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result


check = Solution()
print(check.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))


# TC - O(n); SC - O(n)
# class Solution:
#     def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
#         dictu = {}
#         result = []
#         for i in range(1, len(nums)+1):
#             dictu[i] = 0
#         for i in nums:
#             if i in dictu:
#                 dictu[i] = 1
#         for i in range(1, len(dictu)+1):
#             if dictu[i] == 0:
#                 result.append(i)
#         return result
#
#
# check = Solution()
# print(check.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))


# TC - O(n); SC - O(n)
# class Solution:
#     def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
#         arr = [0] * (len(nums)+1)
#         result = []
#         for i in nums:
#             arr[i] = 1
#         for i in range(1, len(nums)+1):
#             if arr[i] == 0:
#                 result.append(i)
#         return result
#
#
# check = Solution()
# print(check.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))
