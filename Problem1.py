# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
      # hsh = set()
      # for num in nums:
      #   if num in hsh:
      #     continue
      #   hsh.add(num)
      # res = []
      # for i in range(1, len(nums) + 1):
      #   if i not in hsh:
      #     res.append(i)
      # return res

      for i in range(len(nums)):
        if nums[abs(nums[i]) - 1] > 0:
          nums[abs(nums[i]) - 1] *= - 1
      res = []
      for i in range(len(nums)):
        if nums[i] > 0:
          res.append(i + 1)
      return res
