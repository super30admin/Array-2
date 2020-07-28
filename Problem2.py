# ## Problem2
# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

#Time Complexity : O(n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Problem2:

	def FindMinMax1(self, arr):
		min = arr[0]
		max = arr[0]
		for i in arr[1:]:
			if i > max:
				max = i
			if i < min:
				min = i
		return max, min

