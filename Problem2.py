# Time Complexity : O(n) but we are doing 2 * (n - 1) comparisons
# Space Complexity : Constant space, we are using two variables

class Problem2:
	def FindMinMax1(self, arr):
		min_ele = arr[0]
		max_ele = arr[0]
		for i in arr[1:]:
			if i > max_ele:
				max_ele = i
			if i < min_ele:
				min_ele = i
		return max_ele, min_ele

	def FindMinMax2(self, arr):
		min_ele = min(arr[0], arr[1])
		max_ele = max(arr[0], arr[1])
		for i in range(2, len(arr), 2):
			if i == len(arr) - 1:
				max_ele = max(max_ele, arr[i])
				min_ele = min(min_ele, arr[i])
			elif arr[i] > arr[i + 1]:
				max_ele = max(max_ele, arr[i])
				min_ele = min(min_ele, arr[i + 1])
			else:
				max_ele = max(max_ele, arr[i + 1])
				min_ele = min(min_ele, arr[i])
		return max_ele, min_ele

if __name__ == '__main__':
	fmm = Problem2()
	print("Max Element, Min Element", fmm.FindMinMax1([4,3,2,7,8,2,3,1]))
	print("Max Element, Min Element", fmm.FindMinMax2([4,3,2,7,8,2,3,1]))