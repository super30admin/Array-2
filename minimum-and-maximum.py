# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
#if the given array length is odd, initialize the first element as the max and min value
#if the given array length is even, initialize the max of first two elements as max value and similarly for min value
#Only three comparisions are made for each element in the array
nums = [1000, 445 , 330, 3000]
if len(nums) % 2 == 1:
    max_val = nums[0]
    min_val = nums[0]
    for i in range(2, len(nums) - 1):
        if nums[i] > nums [i+1]:
            max_val = max(max_val, nums[i])
            min_val = min(min_val, nums[i+1])
        else:
            max_val = max(max_val, nums[i+1])
            min_val = min(min_val, nums[i])
if len(nums) % 2 == 0:
    max_val = max(nums[0], nums[1])
    min_val = min(nums[0], nums[1])
    for i in range(2, len(nums) - 1):
        if nums[i] > nums [i+1]:
            max_val = max(max_val, nums[i])
            min_val = min(min_val, nums[i+1])
        else:
            max_val = max(max_val, nums[i+1])
            min_val = min(min_val, nums[i])
print(max_val)
print(min_val)
        