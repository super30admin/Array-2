

## Code of Min and Max of array using pairs method to reduce the number of comparisons

def getMinMax(arr):
	
	n = len(arr)
	
	# check even or off, if even assign max and min to first two elements

	if(n % 2 == 0):
		mx = max(arr[0], arr[1])
		mn = min(arr[0], arr[1])
		
		# set the starting index for loop 
		i = 2
		
	else:
		mx = mn = arr[0]
		
		i = 1
		
	while(i < n - 1):
		if arr[i] < arr[i + 1]:
			mx = max(mx, arr[i + 1])
			mn = min(mn, arr[i])
		else:
			mx = max(mx, arr[i])
			mn = min(mn, arr[i + 1])
			
		# Increment the index by 2 as two 
		# elements are processed in loop 
		i += 2
	
	return (mx, mn)
