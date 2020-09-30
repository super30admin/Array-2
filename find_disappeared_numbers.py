#O(N) TIME AND O(1) SPACE
class Solution:
    def findDisappearedNumbers(self, nums):
        missed_numbers = []
        for num in nums:
            idx_to_explore = abs(num) - 1
            nums[idx_to_explore] = -(abs(nums[idx_to_explore]))
        for i in range(len(nums)):
            if nums[i] > 0:
                missed_numbers.append(i+1)
        return missed_numbers