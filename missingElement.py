# Space O(n)
#time O(n)


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        n = len(nums)
        missing_num = [0] * (n + 1)
        missing_num1 = []

        for i in range(0, len(nums)):
            missing_num[nums[i]] = nums[i]

        for i in range(1, len(missing_num)):
            if missing_num[i] == 0:
                missing_num1.append(i)

        return missing_num1