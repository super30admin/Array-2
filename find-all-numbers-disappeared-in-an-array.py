# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Approach 1
# tc O(n), sc O(n, for output list).
# for i in range(len(nums)):
#     while nums[i] != i+1:
#         dest = nums[i] - 1
#         if nums[dest] == nums[i]:
#             break
#         nums[dest], nums[i] = nums[i], nums[dest]

# disappeared_numbers = []
# for idx in range(len(nums)):
#     if nums[idx] != idx + 1:
#         disappeared_numbers.append(idx + 1)

# return disappeared_numbers

# Approach 2
# tc O(n), sc O(n, for output list).
for i in range(len(nums)):
    dest = abs(nums[i]) - 1
    if nums[dest] > 0:
        nums[dest] *= -1

result = []
for num in range(1, len(nums) + 1):
    if nums[num - 1] > 0:
        result.append(num)

return result