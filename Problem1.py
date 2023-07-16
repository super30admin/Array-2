# Approach1 :Brute force
# Time Complexity: O(n^2)
# Space Complexity: O(1)

nums = [4,3,2,7,8,2,3,1]            
result = []
for i in range(len(nums)):                  #O(n)
    if i+1 not in nums:                     #O(n)
        result.append(i+1)
print(result)






# Approach2 :Sorting
# Time Complexity: O(nlogn)
# Space Complexity: O(1)
from numpy import sort

nums = [4, 3, 2, 7, 8, 2, 3, 1]
nums = sort(nums)                                   # O(nlogn)
result =[]
pointer = 1  # Start the pointer from 1 since the range starts from 1
i = 0

while pointer <= len(nums):                         #O(n)
    if nums[i] == pointer:
        i = i + 1
        pointer = pointer + 1
    elif pointer < nums[i]:
        result.append(pointer)
        pointer = pointer + 1
    elif pointer > nums[i]:
         i = i + 1
print(result)





# Approach3 : converting list to set
# Time Complexity: O(n)
# Space Complexity: O(1)
nums = [4, 3, 2, 7, 8, 2, 3, 1]
nums = set(nums)                        #O(n)
result = []
for i in range(len(nums)):              #O(n)
    if i+1 in nums:
        continue
    else:
        result.append(i+1)
print(result)



# Approach4: Using Pointer
# Time Complexity: O(n)
# Space Complexity: O(1)
nums = [4, 3, 2, 7, 8, 2, 3, 1]
result = []
for i in range(len(nums)):
    idx = abs(nums[i]) - 1  # Take the absolute value to handle negative numbers
    if nums[idx] > 0:
        nums[idx] *= -1

for i in range(len(nums)):
    if nums[i] > 0:
        result.append(i + 1)
    else:
        nums[i] *= -1
print(result)

