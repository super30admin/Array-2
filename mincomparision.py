# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to compare 2 elements and if one is greater compare the greater with max, minimum with min var 
#and vice versa if one is lower.

nums=[4,5,0,6,1,9,4,7]
n=len(nums)
mn=99999
mx=-99999
for i in range(0,n-1):
    if (nums[i]<nums[i+1]):
        mn=min(mn, nums[i])
        mx=max(mx, nums[i+1])
    else:
        mn=min(mn, nums[i+1])
        mx=max(mx, nums[i])
    i+=1

print(mn,mx)

