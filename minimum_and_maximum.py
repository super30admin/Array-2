#Time Complexity : O(n)
#Space Complexity: O(1)
#Did your code run : yes
#Approach : In every pair we are doing 3 comparisons and there are n//2 pairs altogether. Therefore total comparison n/2 * 3 = 1.5n

import math
def min_max(nums):
  minimum = math.inf
  maximum = - math.inf
  for i in range(len(nums)-1):
    if nums[i] < nums[i + 1]:
      maximum = max(maximum, nums[i + 1])
      minimum = min(minimum , nums[i])
    else:
      maximum = max(maximum, nums[i])
      minimum = min(minimum , nums[i + 1])
  return [maximum,minimum]


result = min_max([1,2,9,-8,67,100,38,-87])
print("maximum:",result[0])
print("minimum:",result[1])
