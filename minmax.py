def minmax(nums):
    '''
    Space: O(1)
    Time: O(n)
    '''
    if len(nums) == 0:
        return 
    if len(nums) == 1:
        return (nums[0], nums[0])
    min1 = float('inf')
    max1 = -1*float('inf')
    for i in range(0, len(nums)-1):
        if nums[i] <= nums[i+1]:
            max1,min1 = max(max1, nums[i+1]), min(min1, nums[i])    
        else:
            max1,min1 = max(max1, nums[i]), min(min1, nums[i+1])
            
    if len(nums) % 2 == 1:
        max1, min1 = max(max1, nums[-1]), min(min1, nums[-1])
    return (min1,max1)

print(minmax([2,4,5,1,3,8,2,9,10,21]))