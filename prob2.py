# Time Complexity : O(N)
# Space Complexity : O(1) as no extra space, just the output array
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# take the elements in pairs, to reduce the number of comparisons
# comparisons reduce from 2n to 1.5n as we pair up the elements 
# so the becomes n/2 and we do 3 comparisons for each pair
# comparison one: nums[i] > nums[i+1] 
# if nums[i] is greater than nums[i+1], 
# then compare nums[i] with current max,
# then compare nums[i+1] with current min

def minmax(nums):
    mymax = nums[0]
    mymin = nums[0]
    for i in range(len(nums) - 1):
        if nums[i] < nums[i+1]:
            mymin = min(mymin, nums[i])
            mymax = max(mymax, nums[i+1])
        else:
            mymin = min(mymin, nums[i+1])
            mymax = max(mymax, nums[i])
    if len(nums) % 2 == 1:
        if mymax < nums[-1]:
            mymax = nums[-1]
        if mymin > nums[-1]:
            mymin = nums[-1]
    
    return [mymin, mymax]


nums = [1000, 11, 445, 1, 330, 3000]
print(minmax(nums))