# Time: O(n)
# Space: O(n)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            if nums[abs(num)-1] > 0:
                    nums[abs(num)-1] *= -1
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result 
