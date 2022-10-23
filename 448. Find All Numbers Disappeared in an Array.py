# Time Complexity O(n)
# Space Complexity O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for item in nums:
            dummy = abs(item) - 1
            if nums[dummy] > 0:
                nums[dummy] = -1 * nums[dummy]

        ans = []
        for index, item in enumerate(nums):
            if item > 0:
                ans.append(index + 1)

        return ans