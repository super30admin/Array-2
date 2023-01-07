# Time Complexity :
# O(N)  - Size of the array

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
# This code ran on geeksForGeeks

#We compare elements in pairs - if one is bigger than the other, we only compare the bigger one with max and the smaller one with min
def getMinMax(arr):
	min_value = arr[0]
	max_value = arr[0]
    
	for i in range(1,len(arr)):
		if i + 1 < len(arr):
			if arr[i] < arr[i+1]:
				min_value = min(min_value,arr[i])
				max_value = min(max_value,arr[i+1])
			else :
				min_value = min(min_value,arr[i+1])
				max_value = min(max_value,arr[i])
		else :
			min_value = min(min_value,arr[i])
			max_value = min(max_value,arr[i])

	return (max_value, min_value)
