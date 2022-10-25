# Time Complexity: O(n)
# Space Complexity: O(1)

# The intuition to solve this problem is that we use the fact that the array has numbers [1, n].

# In order to not use any additional space, we go the index (equal to value of number at position i) and mark the number as negative, or visited.

# Once we do that, only the indices which are not present in the array, would have a positive value. That would be the answer to this question.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        n = len(nums)
        if nums is None:
            return result
        for i in range(n):
            idx = abs(nums[i]) - 1
            if (nums[idx] > 0):
                nums[idx] *= -1
            
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
        return result


# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        n = len(nums)
        if nums is None:
            return result
        
        missingDict = {}
        for i in range(1, n + 1):
            missingDict[i] = False
        
        for num in nums:
            missingDict[num] = True
        
        result = []
        for key, val in missingDict.items():
            if val == False:
                result.append(key)
                
        return result
