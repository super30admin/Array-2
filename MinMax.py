# Problem2 Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

def minMax(nums):
    minVal = maxVal = nums[0]
    for i in range(len(nums)-1):
        if nums[i] < nums[i+1]:
            minVal = min(nums[i], minVal)
            maxVal = max(maxVal, nums[i+1])
        else:
            minVal = min(nums[i+1], minVal)
            maxVal = max(maxVal, nums[i])

#time complexity O(n)
#space complexity O(1)
#can be done in 2 * (N - 2) comparisons