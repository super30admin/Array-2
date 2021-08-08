class Solution:
    """
    Look for normal indexes items since it always stars and includes 1
    TC - O(n^2)
    Sc - O(1)
    """
    def approach1(self, nums):
        ans = []
        for i in range(1, len(nums) + 1):
            if i not in nums:
                ans.append(i)
        return ans

    """
    Marking numbers which are present on their indeces
    TC - O(n)
    SC - O(1)
    """
    def approach2(self, nums):
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = 0 - nums[index]
        ans = []
        for loc, num in enumerate(nums):
            if num > 0:
                ans.append(loc + 1)
        return ans

    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        return self.approach2(nums)