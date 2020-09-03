#Time Complexity : O(n) but less than 2(n-1). Number of comaprisons is (3n/2)+2 (extra 2 if length of the array is odd)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach

def max_min(nums):
    prev_max=float('-inf')
    prev_min=float('inf')
    
    if len(nums)%2==0: 
        for i in range(0,len(nums),2):
            if nums[i]<nums[i+1]:
                c_max=nums[i+1]
                c_min=nums[i]
            else: 
                c_max=nums[i]
                c_min=nums[i+1]
            if c_max>prev_max:
                prev_max=c_max
            if c_min<prev_min: 
                prev_min=c_min
        return prev_max,prev_min    
    else: 
        for i in range(0,len(nums)-1,2):
            if nums[i]<nums[i+1]:
                c_max=nums[i+1]
                c_min=nums[i]
            else: 
                c_max=nums[i]
                c_min=nums[i+1]
            if c_max>prev_max:
                prev_max=c_max
            if c_min<prev_min: 
                prev_min=c_min
            if nums[len(nums)-1]>prev_max:
                prev_max=nums[len(nums)-1]
            if nums[len(nums)-1]<prev_min:
                prev_min=nums[len(nums)-1]
        return prev_max,prev_min

if __name__ == "__main__":
    nums=[3,4,2,3,7,5,9,11,15]
    print(max_min(nums))