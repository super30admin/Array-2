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