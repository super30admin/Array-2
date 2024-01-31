# Time Complexity: O(N)
# Space Complexity: O(1)

def findMinMax(nums):
  minV = float("inf")
  maxV = -float("inf")
  for i in range(0, len(nums), 2):
    if nums[i] < nums[i+1]:
      minV = min(nums[i], minV)
      maxV = max(num[i+1], maxV)
    else:
      minV = min(nums[i+1], minV)
      maxV = max(num[i], maxV)

  if len(nums) % 2 != 0:
    minV = min(nums[-1], minV)
    maxV = max(nums[-1], maxV)

  return minV, maxV
