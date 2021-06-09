def min_max(nums):
    
    """
    :rtype: int
    :time complexity -  O((n/2)+n)
    """
    #initialize min and max with + and - infinity
#     maxx = float('-inf')
#     minn = float('inf')

    n=len(nums)
    i=0
    
    # check if len even or odd
    if n % 2 ==0:
        maxx = max(nums[0],nums[1])
        minn = max(nums[0],nums[1])
        i=2
    else:
        minn=maxx=nums[0]
        i=1
        
    # iterate from i =2 in pair with incrementing by 2
    while(i<n-1):
        
        if  (i+1) <= n and nums[i]>nums[i+1]:
            maxx=max(maxx, nums[i])
            minn=min(minn, nums[i+1])
#             print(maxx)
#             print(minn)
        elif (i+1) <= n and nums[i]<nums[i+1]:
            maxx=max(maxx, nums[i+1])
            minn=min(minn, nums[i])
#             print(maxx)
#             print(minn)
        i+=2
        
    return maxx, minn

arr= [4,3,5,1,6,0,7]
min_max(arr)
            
