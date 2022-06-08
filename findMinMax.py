# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def getMinMax(arr):

	n = len(arr)

	if len(arr) % 2 == 0:
		my_min = min(arr[0],arr[1])
		my_max = max(arr[0],arr[1])
		j = 2
	
	else:
		my_min = my_max = arr[0]
		j = 1

	for i in range(j,n-1,2):

		if arr[i] < arr[i+1]:
			my_min = min(my_min, arr[i])
			my_max = max(my_max, arr[i+1])

		else:
			my_min = min(my_min, arr[i+1])
			my_max = max(my_max, arr[i])

	return (my_min, my_max)
	
if __name__ =='__main__':
     
	arr = [1000, 11, 445, 1, 330, 3000]
	mn, mx = getMinMax(arr)
	print("Minimum element is", mn)
	print("Maximum element is", mx)