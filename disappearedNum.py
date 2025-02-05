"""
Array approach --
TC - O(n)
SC - O(1)
"""


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0: return []

        n = len(nums)
        rtnData = []

        # 1st pass
        for i in range(n):
            idx = abs(nums[i]) - 1
            # if number positive only then make it negative. else leave as it is
            if nums[idx] > 0:
                nums[idx] *= -1

        # 2nd pass
        for i in range(n):
            # there will be positive numbers left. get its index + 1 and append to rtnData
            if nums[i] > 0:
                rtnData.append(i + 1)
            # reset nums to original values since we mutated the array
            # so we return the original one
            else:
                nums[i] *= -1

        return rtnData
