"""
Simple approach where we maintain the min in nums[0] and max in nums[1]
we iterate over the n-2 elements in the array and swap with nums[0] . or nums[1] to ensure that nums[0] < nums[i] < nums[1]

Time complexity O(N) 2*(N-2) comparisons
Space complexity O(1)
"""
def minmax(self,nums) :
	if len(nums) == 1 :
		return [nums[0],nums[0]]

	if len(nums) == 2 :
		return [nums[1],nums[0]] if nums[1] < nums[0] else [nums[0],nums[1]]

	if nums[0] > nums[2] :
		nums[0], nums[2] = nums[2], nums[0]

	for i in range(2,N) :
		# this ensures nums[i] > nums[0]
		if nums[0] > nums[i] :
			nums[0], nums[i] = nums[i], nums[0]

		# this ensures nums[1] > nums[i] > nums[0]
		if nums[1] < nums[i] :
			nums[1], nums[i] = nums[i], nums[1]

	return nums[0],nums[1]
