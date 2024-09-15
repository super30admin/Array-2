"""
Time Complexity 0(N)
Space Complexity O(1)

For each idx in nums,we mark the number that idx points as negative.
Then we filter the list, get all the indexes who points to a positive number as numbered disappeared in array
"""

class Solution_disappeared:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums)==0:
            return []
        print(nums)
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            nums[idx] = - abs(nums[idx])
            print(nums)
        return [i + 1 for i in range(len(nums)) if nums[i] > 0]
        