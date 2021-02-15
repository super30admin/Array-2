"""Find Min and Max values
No of Comparisions - 1.5*n + 2
Time Complexity - O(n)
Space Complexity - O(1)
Made groups of 2 elements in a list and compared which is greater
    Compare greater value with max_val and update max_val 
    Compare smaller value with min_val and update value of mi_val
for odd length compare last element with max_val and min_val"""
nums = [2,5,6,7,8,9,1]
i = 0
min_val = float("inf")
max_val = float("-inf")
while(i < len(nums) and i+1 < len(nums)):
    if (nums[i] < nums[i+1]):
        if nums[i] < min_val:
            min_val = nums[i]
        if nums[i+1] > max_val:
            max_val = nums[i+1]
    elif (nums[i] > nums[i+1]):
        if nums[i] < min_val:
            min_val = nums[i]
        if nums[i+1] > max_val:
            max_val = nums[i+1]
    else:
        if nums[i] < min_val:
            min_val = nums[i]
        if nums[i+1] > max_val:
            max_val = nums[i+1]
    i += 2

if i < len(nums):
    if nums[i] < min_val:
        min_val = nums[i]
    if nums[i] > max_val:
        max_val = nums[i]

print("Min",min_val)
print("Max:",max_val)

    