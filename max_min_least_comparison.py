def getMinMax(arr):
	minn = arr[0]
	maxx = arr[0]

	for i in range(1,len(arr)):
		if i + 1 < len(arr):
			if arr[i] < arr[i+1]:
				minn = min(minn,arr[i])
				maxx = min(maxx,arr[i+1])
			else :
				minn = min(minn,arr[i+1])
				maxx = min(maxx,arr[i])
		else :
			minn = min(minn,arr[i])
			maxx = min(maxx,arr[i])

	return (maxx, minn)
