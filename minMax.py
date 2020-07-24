# Find Min & max of array in less than 2*(n-1) comparisions

# Time Complexity : O(n) where n is the size of the array

# Space Complexity : O(1)

# Comparisons: (3n/2)-2

# Any problem you faced while coding this : No

# Approach: initialize the minn & maxx to the smaller and larger of the first two elements.
# Iterate over the array until n-1 element in two increments and compare the pair of first two elements, larger is compared
# with maxx and smaller one is compared with minn. Update the minn and maxx accordingly and return after the
# entire array is traversed.

# Your code here along with comments explaining your approach

def minMax(nums):
    if not nums or len(nums) == 0:
        return -1

    if len(nums) == 1:
        return [nums[0], nums[0]]

    minn = 0
    maxx = 0

    if nums[0] > nums[1]:
        maxx = nums[0]
        minn = nums[1]
    else:
        maxx = nums[1]
        minn = nums[0]

    for i in range(2, len(nums)-1, 2):
        if nums[i] > nums[i+1]:
            maxx = max(nums[i], maxx)
            minn = min(nums[i+1], minn)
        elif nums[i] < nums[i+1]:
            maxx = max(nums[i+1], maxx)
            minn = min(nums[i], minn)

    # if len of nums is odd
    if len(nums) % 2 == 1:
        maxx = max(nums[len(nums)-1], maxx)
        minn = min(nums[len(nums)-1], minn)

    return [maxx, minn]


nums = [0, 1, 3, 5, 7, 9, 12, 4, 6, 8]

print(minMax(nums))
