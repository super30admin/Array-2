# Approach: With less than 2*(n-2) comparisons
# If n is odd then initialize min and max as first element. So that we can compare next n-1 numbers in pair
# If n is even then initialize min and max as minimum and maximum of the first two elements respectively. So that we can compare next n-2 numbers in pair
# For rest of the elements, pick them in pairs and compare their 
# maximum and minimum with max and min respectively. 

# Time complexity: O(n)
# Space complexity: O(1)



class Solution:
	def getMinMax(self, arr):

		n = len(arr)

		if n%2 == 0:
			mini = min(arr[0], arr[1])
			maxi = max(arr[0], arr[1])

			i = 2
		else:
			mini = arr[0]
			maxi = arr[0]

			i = 1

		while i < n - 1:
			if arr[i] < arr[i+1]:
				maxi = max(maxi, arr[i+1])
				mini = min(mini, arr[i])\
			else:
				maxi = max(maxi, arr[i])
				mini = min(mini, arr[i+1])

		return [maxi, mini] 