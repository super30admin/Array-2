# Time Complexity : O(n) but we are doing 2 * (n - 1) comparisons
# Space Complexity : Constant space, we are using two variables

class Problem2:
	def FindMinMax(self, arr):
		min_ele = arr[0]
		max_ele = arr[0]
		for i in arr[1:]:
			if i > max_ele:
				max_ele = i
			if i < min_ele:
				min_ele = i
		return max_ele, min_ele

if __name__ == '__main__':
	fmm = Problem2()
	print("Max Element, Min Element", fmm.FindMinMax([4,3,2,7,8,2,3,1]))