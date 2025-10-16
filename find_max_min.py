# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def findMaxMin(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        max_num = nums[0]
        min_num = nums[0]
        # Consider a window of size 2
        # Compare elements in pairs to reduce the number of comparisons
        # This approach makes about 3n/2 comparisons in the worst case, instead of 2n comparisons
        # Iterate through the list in steps of 2, comparing pairs, and updating max and min accordingly
        for i in range(0, len(nums) - 1, 2):
            if nums[i] > nums[i + 1]:
                max_num = max(max_num, nums[i])
                min_num = min(min_num, nums[i + 1])
            else:
                max_num = max(max_num, nums[i + 1])
                min_num = min(min_num, nums[i])
        # If there's an odd element out, compare it separately
        if len(nums) % 2 != 0:
            max_num = max(max_num, nums[-1])
            min_num = min(min_num, nums[-1])
        return [max_num, min_num]