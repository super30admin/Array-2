# Python program of above implementation
def getMinMax(low, high, arr):
	arr_max = arr[low]
	arr_min = arr[low]
	
	# If there is only one element
	if low == high:
		arr_max = arr[low]
		arr_min = arr[low]
		return (arr_max, arr_min)
		
	# If there is only two element
	elif high == low + 1:
		if arr[low] > arr[high]:
			arr_max = arr[low]
			arr_min = arr[high]
		else:
			arr_max = arr[high]
			arr_min = arr[low]
		return (arr_max, arr_min)
	else:
		
		# If there are more than 2 elements
		mid = int((low + high) / 2)
		arr_max1, arr_min1 = getMinMax(low, mid, arr)
		arr_max2, arr_min2 = getMinMax(mid + 1, high, arr)

	return (max(arr_max1, arr_max2), min(arr_min1, arr_min2))

# Driver code
arr = [1000, 11, 445, 1, 330, 3000]
high = len(arr) - 1
low = 0
arr_max, arr_min = getMinMax(low, high, arr)
print('Minimum element is ', arr_min)
print('nMaximum element is ', arr_max)


