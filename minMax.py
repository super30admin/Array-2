#Time Complexity: O(1.5n)=O(n)
#Space Complexity: O(1)
def minMax(nums):
    minnum=nums[0]
    maxnum=nums[0]
    for i in range(0,len(nums),2):
        if nums[i]>nums[i+1]:
            maxnum=max(maxnum,nums[i])
            minnum=min(minnum,nums[i+1])
        elif nums[i+1]>nums[i]:
            maxnum=max(maxnum,nums[i+1])
            minnum=min(minnum,nums[i])
    return maxnum,minnum
            
res=minMax([1000, 11, 445, 1, 330, 3000])
print(res)