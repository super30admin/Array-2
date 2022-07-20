# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0 or nums is None:
            return []

        result= []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
            else:
                nums[i] = nums[i] * -1
        
        return result
    

# My Solution
# class Solution:
#     def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
#         if len(nums) == 0 or nums is None:
#             return []

#         result = []
#         for i in range(1, len(nums) + 1):
#             result.append(i)

#         for i in range(len(nums)):
#             if nums[i] in result:
#                 result.remove(nums[i])
#             else:
#                 pass
        
#         return result
    