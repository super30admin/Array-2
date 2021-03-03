#time_complexity: o(n/2)
#space_complexity: o(1)

import sys
def minMax(nums):
  if len(nums) % 2 == 0:
    minimum = sys.maxsize
    maximum = 1
    return maxMinCal(nums, 0,maximum, minimum)
  else:
    minimum = nums[0]
    maximum = nums[0]
    return maxMinCal(nums, 1, maximum, minimum)
def maxMinCal(nums,start,maximum, minimum):
  for i in range(start,len(nums),2):
    if i+1 < len(nums):
      temp_sum = nums[i] + nums[i+1]
      temp_max = max(nums[i],nums[i+1])
      temp_min = temp_sum - temp_max
      minimum = min(minimum, temp_min)
      maximum = max(temp_max, maximum)
  return [maximum,minimum]
print(minMax([5,6,7,3,2,1,8,9,4]))
