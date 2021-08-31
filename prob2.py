
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