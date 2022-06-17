'''
Time Complexity : O(n)
Space Complexity : O(1)
No execution on github but works fine on my system
'''

class pair:
	def __init__(self):
		self.min = 0
		self.max = 0

def getMinMax(arr: list, n: int) -> pair:
	minmax = pair()

	if n == 1:
		minmax.max = arr[0]
		minmax.min = arr[0]
		return minmax

	if arr[0] > arr[1]:
		minmax.max = arr[0]
		minmax.min = arr[1]
	else:
		minmax.max = arr[1]
		minmax.min = arr[0]

	for i in range(2, n):
		if arr[i] > minmax.max:
			minmax.max = arr[i]
		elif arr[i] < minmax.min:
			minmax.min = arr[i]

	return minmax


if __name__ == "__main__":
	arr = [23,400,25,6,100,314,0]
	arr_size = 7
	minmax = getMinMax(arr, arr_size)
	print("Minimum element:", minmax.min)
	print("Maximum element:", minmax.max)

