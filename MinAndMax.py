def getMinAndMax(nums):
    i = 0;
    j = 1;
    global_max = float('-inf')
    global_min = float('inf')
    
    while (i < len(nums) and j < len(nums)):
        if(nums[i] > nums[j]):
            maxi = nums[i]
            mini = nums[j]
        else:
            maxi = nums[j]
            mini = nums[i]
        if(maxi > global_max):
            global_max = maxi
        if(mini < global_min):
            global_min = mini
        i += 2
        j += 2
    return global_min, global_max


res = getMinAndMax([1,2,3,4,5,6,7,8,9,10])

print res
