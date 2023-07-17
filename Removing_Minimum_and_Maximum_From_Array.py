class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        Min= nums.index(min(nums))
        Max= nums.index(max(nums))
        return min(max(Min, Max)+1, len(nums)-min(Min, Max), len(nums)+1+min(Min, Max)-max(Min, Max))
        