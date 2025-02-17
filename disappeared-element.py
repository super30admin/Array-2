# Time Complexity: O(n) (since we traverse the array twice)
# Space Complexity: O(1) (modifies input array in place, ignoring output storage)
# It marks visited numbers by negating the value at their corresponding index, then finds missing numbers by checking 
# which indices remain positive.
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        n = len(nums)
        for i in range(n):
            nums[abs(nums[i]) - 1] = abs(nums[abs(nums[i]) - 1]) * -1
        for i in range(n):
            if nums[i] > 0:
                res.append(i+1)
        return res