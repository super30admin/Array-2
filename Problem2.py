#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

nums = [1000,11,445,19000,330,3000,20000]
maxx = float('-inf')
minn = float('inf')
for i in range(0,len(nums)-1,2):
    j = i + 1
    maxx = max(maxx,max(nums[i],nums[j]))
    minn = min(nums[i],min(nums[j],minn))
    
if len(nums) % 2 !=0 :
    maxx = max(maxx,nums[-1])
    minn = min(nums[-1],minn)
    
print("Min element is", minn)
print("Maxx ele is ",maxx)
    
    
    