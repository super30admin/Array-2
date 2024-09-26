def find_min_max(array):
	min_ = 0
	max_ = 0
	i = 0
	while(i<len(array) and i+1<len(array)):
		if array[i]<array[i+1]:
			max_ = max(max_, array[i+1])
			min_ = min(min_, array[i])
		else:
			max_= max(max_, array[i])
			min_ = min(min_, array[i+1])
		i+=2
	return min_, max_

#Time complexity - O(n)
#Space complexity - O(1)

#Number of iterations = 1.5n, where n = length of array