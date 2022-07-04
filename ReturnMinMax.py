
"""
M1 - sort and pick max and min
M2 - we maintain two variables- min and max and we compare at every point with the current min and max
total comp = 2n

M3 - We compare in pairs and for evey pair, we compare bigger element with existing max and smaller element with existing min


"""

nums = [1,2,4,-2,3,6,7,-7]
if nums[0]<nums[1]:
    vmin = nums[0]
    vmax = nums[1]
else:
    vmin = nums[1]
    vmax = nums[0]

for i in range(len(nums)-1):
    if nums[i]>nums[i+1]:
        vmax= max(nums[i], vmax)
        vmin = min(nums[i+1], vmin)
    else:
        vmax = max(nums[i+1], vmax)
        vmin = min(nums[i], vmin)
print('min:', vmin)
print('max:', vmax)

