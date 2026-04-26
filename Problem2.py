# Time Comkplexity --> O(n)
# Space Complexity --> O(1)
# Total Comparisons --> 1.5*n. We are comparing a pair of numbers at a time and then comparing the minimum of them with existing min value and maximum of them with existing max value
def findMinAndMax(self, nums):
      n = len(nums)
      i = 0

      ## Different initializations depending on whether the length of array is even or odd
      if n % 2 == 0:
          min_val = min(nums[0], nums[1])
          max_val = max(nums[0], nums[1])
          i = 2
      else:
          min_val = max_val = nums[0]
          i = 1

      while i < n - 1:
          if nums[i] < nums[i + 1]:
              min_val = min(min_val, nums[i])
              max_val = max(max_val, nums[i + 1])
          else:
              min_val = min(min_val, nums[i + 1])
              max_val = max(max_val, nums[i])
          i += 2

      return [min_val, max_val]
