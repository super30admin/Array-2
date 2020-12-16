# Time complexity = O(n) ; n = length of array
# Space complexity = O(1) ; We don't use any auxilary data structure to compute anything
# Approach: Go through whole array, make numbers negative if not already by going subracting 1 from numbers and going 
# to corresponding index. In the next pass, we find which number is positive, that number's index + 1 number is missing.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        if len(nums) == 0:
            return result
        
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
                
        return result


# Time complexity = O(n) ; n = length of array
# Space complexity = O(n) ; As we use Hashmap to store count of numbers
# class Solution:
#     def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
#         if len(nums) == 0:
#             return []
        
#         hashmap = collections.Counter(nums)
#         result = []
        
                
#         for i in range(1, len(nums) + 1):
#             if i not in hashmap:
#                 result.append(i)
                
#         return result