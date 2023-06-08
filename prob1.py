#  Time Complexity : O(n)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        output = list()
        for i in range(n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        for i in range(n):
            if nums[i] > 0:
                output.append(i+1)
            # else:
            #     nums[i] *= -1

        return output
