import sys

class Solution:
	def minMax(self, nums):
		if not nums:
			return

		if len(nums)%2 == 0:
			return self.helper(nums, 0, len(nums))
		else:
			firstVal = nums[0]
			minVal, maxVal = self.helper(nums, 1, len(nums))
			if firstVal < minVal:
				return firstVal, maxVal
			elif firstVal > maxVal:
				return minVal, firstVal
			else:
				return minVal, maxVal

	def helper(self, nums, x, y):

		minVal = sys.maxsize
		maxVal = -sys.maxsize

		for i in range(x, y-1):
			if nums[i]>nums[i+1]:
				maxVal = max(maxVal, nums[i])
				minVal = min(minVal, nums[i+1])
			else:
				maxVal = max(maxVal, nums[i+1])
				minVal = min(minVal, nums[i])

		return minVal, maxVal


s = Solution()
arr = [7,3,2,8,6,9,1,13,14]
print(s.minMax(arr))

# TC:O(N) SC: O(1)
# evaluating in pairs. handling odd and even number of elements
# for every pair, there are 3 iterations. hence reducing total iterations by 25%
