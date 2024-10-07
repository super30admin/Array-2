nums = [4,8,-1,0,7,-3,6]
n = len(nums)

def MaxMin(nums):
    min1 = 100
    max1 = -100
    for i in range(0,n-1,2):
        if(nums[i]<nums[i+1]):
            min1 = min(nums[i],min1)
            max1 = max(nums[i+1],max1)
        else:
            min1 = min(nums[i+1],min1)
            max1 = max(nums[i],max1)

    if(n%2 != 0):
        min1 = min(nums[-1],min1)
        max1 = max(nums[-1],max1)

    return min1,max1

print(MaxMin)

min_value, max_value = MaxMin(nums)
print("Minimum:", min_value)
print("Maximum:", max_value)
