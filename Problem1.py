class Problem1:
	def FindMissingElements1(self, arr):
		# Time Complexity : O(n) where n is the number of elements in the array
		# Space Complexity : O(n) where n is the number of elements in the array
		result_arr = [0] * (len(arr) + 1)
		for i in arr:
			result_arr[i] += 1
		temp = []
		for index, val in enumerate(result_arr):
			if index != 0 and val == 0:
				temp.append(index)
		return temp

	def FindMissingElements2(self, arr):
		# Time Complexity : O(n) where n is the number of elements in the array
		# Space Complexity : constant space just using the output array
		for i in range(len(arr)):
			index = abs(arr[i]) - 1
			if arr[index] > 0:
				arr[index] *= -1
		res = []
		for index, val in enumerate(arr):
			if val > 0:
				res.append(index + 1)
		return res

if __name__ == '__main__':
	fme = Problem1()
	print(fme.FindMissingElements1([4,3,2,7,8,2,3,1]))
	print(fme.FindMissingElements2([4,3,2,7,8,2,3,1]))