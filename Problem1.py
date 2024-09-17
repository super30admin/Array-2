nums=[7,2,11,13,9,18]
n=len(nums)
min=nums[0]
max=nums[0]



#Method -1
#Time Complexity- O(n)
#Comparision:
#Worst case - 2(n-1)
#best case - (n-1)

for i in range(n):
    if(nums[i]<=min):
        min=nums[i]
    if(nums[i]>=max):
        max=nums[i]

print(min)
print(max)

#Method -2
#Time Complexity- O(n)
#Comparision: 3n/2 -2
def minmax(start,end,nums):
    nmin=nums[start]
    nmax=nums[start]
    
    if(start==end):
        nmin=nums[start]
        nmax=nums[start]
        return(nmax,nmin)

    elif (end==start+1):
        if nums[start]>nums[end]:
            nmax=nums[start]
            nmin=nums[end]
        else:
            nmax=nums[end]
            nmin=nums[start]
        return(nmax,nmin)

    else:
        mid = (start + end) // 2 
        max1, min1 = minmax(start, mid, nums) 
        max2, min2 = minmax(mid + 1, end, nums) 
  
    return (max(max1, max2), min(min1, min2)) 
        
end = len(nums) - 1
start = 0
nmax, nmin = minmax(start, end, nums) 
print(nmax)
print(nmin)      


