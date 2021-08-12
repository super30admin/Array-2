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

