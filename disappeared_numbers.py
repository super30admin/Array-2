# O(N) TIME AND O(1) SPACE WHERE N IS LEN(NUMS)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            idx = abs(num)
            nums[idx - 1] = -(abs(nums[idx - 1]))
        missed_nums = []
        for i,num in enumerate(nums):
            if num > 0:
                missed_nums.append(i+1)
        return missed_nums
    