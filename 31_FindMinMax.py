# time - O(N), O(1)
# iterate through the loop and compare with min and max elements.
# second version reduce the number of comparisions by comparing min, max as pairs instead of comparing both with each element.
def FindMinMax(nums):
    if len(nums) == 0 or nums is None:
        return
    mini = nums[0]
    maxi = nums[0]
    for i in range(len(nums)):
        if nums[i] < mini:
            mini = nums[i]
        if nums[i] > maxi:
            maxi = nums[i]
    return [mini,maxi]

print("[Min,Max]: ",FindMinMax([]))

def FindMinMax2(nums):
    if len(nums) == 0 or nums is None:
        return
    elif len(nums) == 1:
        [mini, maxi] = [nums[0], nums[0]]
        return [mini, maxi]
    else:
        [mini,maxi] = [min(nums[0],nums[1]),max(nums[0],nums[1])]
    for i in range(0,len(nums),2):
        if i+1 != len(nums):
            mi = min(nums[i], nums[i+1])
            ma = max(nums[i], nums[i+1])
            if mi < mini:
                mini = mi
            if ma > maxi:
                maxi = ma
        else:
            if nums[i] < mini:
                mini = nums[i]
            if nums[i] > maxi:
                maxi = nums[i]
    return [mini,maxi]

print(FindMinMax2([]))