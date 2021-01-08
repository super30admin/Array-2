'''
    Time Complexity:
        O(n)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        State Change the index corresponding to the positive number to -ve in the first pass.
        In the second pass:
        -> If a number is still positive:
            Then, its corresponding index (+ 1) was originally missing,
        -> Else:
            (Optionally) State change it back to positive.
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []

        for i, num in enumerate(nums):
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        for i, num in enumerate(nums):
            if num > 0:
                res.append(i + 1)
            else:
                nums[i] *= -1

        return res
