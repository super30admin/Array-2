def MinMax(nums): #Tc: O(n) SC: O(1)
    n=len(nums)
    i=0
    min_val=0
    max_val=0
    if n%2==0:
        if nums[0]<nums[1]:
            min_val=nums[0]
            max_val=nums[1]
        else:
            min_val=nums[1]
            max_val=nums[0]
        i=2
    else:
        min_val=max_val=nums[0]
        i=1
    while i<n-1:
        if nums[i]<nums[i+1]:
            min_val=min(nums[i],min_val)
            max_val=max(nums[i+1],max_val)
        else:
            min_val=min(nums[i+1],min_val)
            max_val=max(nums[i],max_val)
        i+=2
    return [min_val,max_val]
    
nums=[3,28,7,2,19,9]
print(MinMax(nums))