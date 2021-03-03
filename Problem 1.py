#Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = [] * len(nums)
        # Edge case
        if nums == None or len(nums) == 0:
            return res

        # Logic
        for i in range(len(nums)):
            idx = abs(nums[i])
            if nums[idx - 1] > 0:
                nums[idx - 1] = nums[idx - 1] * -1

        for j in range(len(nums)):
            if nums[j] < 0:
                continue
            else:
                res.append(j + 1)
        return res