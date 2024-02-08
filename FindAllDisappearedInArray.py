# Time complexity - O(n) n is the number of elements
# Space complexity - O(1) we do not use any space for computation

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        # In this solution I am gonna iterate over list
        # Whatever value I get from a particular index, I just go that particular index and make value negative
        # At the end I will just check which indexes left positive and get those indexes + 1
        for i in nums:
            if nums[abs(i) - 1] > 0:
                nums[abs(i) - 1] *= -1
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result
