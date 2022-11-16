def max_min(nums):
    
    ## T.C = O(3.(n/2))
    ## S.C = O(1)
    
    if not nums:
        return -1
    
    if len(nums) == 1:
        return [nums[0], nums[0]]
    
    n = len(nums) - 1
    mn = min(nums[0], nums[1])
    mx = max(nums[0], nums[1])
    
    for i in range(2, len(nums), 2):
        if i+1 <= n and nums[i] < nums[i+1]:
            mn = min(mn, nums[i])
            mx = max(mx, nums[i+1])

        elif i+1 <= n and nums[i] > nums[i+1]:
            mn = min(mn, nums[i+1])
            mx = max(mx, nums[i])
        
    
    if n % 2 == 0:
        mn = min(mn, nums[-1])
        mx = max(mx, nums[-1])

    return [mn, mx]

nums = [4, 7, 2, 3, 100, 10, -1, 20, 2000]
x = max_min(nums)
print(x)

