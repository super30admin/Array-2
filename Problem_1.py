from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -1 * nums[index]
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = abs(nums[i])
            else:
                result.append(i+1)
        return result

obj = Solution()
print(obj.findDisappearedNumbers([4,3,2,7,8,2,3,1]))
print(obj.findDisappearedNumbers([1,1]))

# Time Complexity: O(n)
# Space Complexity: O(1)