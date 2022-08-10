# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List


class Solution:
    def find_min_max(self, nums: List[int]) -> (int, int):
        _min, _max = 0, 0
        _len = len(nums)
        idx = 0
        while idx < _len//2:
            if nums[2*idx] > nums[2*idx - 1]:
                _max = max(_max, nums[2 * idx])
                _min = min(_min, nums[2 * idx - 1])
            else:
                _max = max(_max, nums[2 * idx - 1])
                _min = min(_min, nums[2 * idx])
            idx += 1
        return _min, _max


if __name__ == '__main__':
    arr = [1, 4, 5, -2, 6, -10, -20]
    print(Solution().find_min_max(arr))
