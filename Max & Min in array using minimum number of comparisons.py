#Given an array of numbers of length N, find both the minimum and maximum. 
#Follow up : Can you do it using less than 2 * (N - 2) comparison

# Time Complexity : If n is odd:    3*(n-1)/2  
					#If n is even:   1 Initial comparison for initializing min and max, 
					#and 3(n-2)/2 comparisons for rest of the elements  
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


def getMinMax(arr):
	n = len(arr)
	
	if n % 2 == 0:
		maxN = max(arr[0], arr[1])
		minN = min(arr[0], arr[1])
		startIdx = 2
	else:
		maxN = minN = arr[0]
		startIdx = 1
		
	for i in range(startIdx, len(arr)-1):
		if arr[i] < arr[i+1]:
			maxN = max(maxN, arr[i+1])
			minN = min(minN, arr[i])
		else:
			maxN = max(maxN, arr[i])
			minN = min(minN, arr[i+1])
			
	return (maxN,minN)
	


# Driver code
if __name__ == '__main__':
	arr = [1000, 11, 445, 1, 330, 3000]
	mx, mn = getMinMax(arr)
	print("Minimum element is", mn)
	print("Maximum element is", mx)