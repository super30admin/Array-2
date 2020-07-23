# Time Complexity : O(1.5n - 2) (Using Master's theorem for T(1)=0, T(2)=1, T(n) = 2*T(n/2) +2)
# Space Complexity: O(logn)
# Works on leetcode: Not on leetcode
# Approach: We use divide and conquer strategy here and recursively slice the array in half and find their maximum and 
# minimum. 
def minmax(nums):
	l, h = 0,len(nums)-1
	minn, maxx = nums[l], nums[l]

	if l==h:
		minn, maxx = nums[l], nums[l]
		return (minn, maxx)
	elif h==(l+1):
		if nums[l]>nums[h]:
			minn, maxx = nums[h],nums[l]
		else:
			minn, maxx = nums[l], nums[h]
		return (minn, maxx)
	else:
		mid = (l+h)//2
		min1, max1 = minmax(nums[:mid])
		min2, max2 = minmax(nums[mid:])
		return (min(min1,min2), max(max1,max2))

print(minmax([3,7,3,8,99,12,-9]))