class Solution:
    """
    Time complexity - O(n). n - size of nums
    Space complexity - O(1)
    """
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        result = []
        for index, num in enumerate(nums):
            num = abs(num)
            if nums[num-1] > 0:
                # mark the number seen 
                nums[num-1] = -1 * nums[num-1]
        for index, num in enumerate(nums):
            if num > 0:
                result.append(index+1)
        return result