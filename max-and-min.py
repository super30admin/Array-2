def findMinMax(arr):
	mn = float('inf')
	mx = float('-inf')

	for num in nums:
		if num < mn: 
			mn = num 
		elif mx > num:
			mx = num 

	return [mn,mx]