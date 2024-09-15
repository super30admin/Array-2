// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not present in leetcode ran this on IDE and worked fine on all the edge cases.
// Any problem you faced while coding this : for odd number of array we had to adjust the edge cases.

// Your code here along with comments explaining your approach
we start by taking the array in pairs and take the min and max element out of it and maintain them in a temporary variable and you keep on doing this procedure till we reach the end of the array.In the end the temporary variables will give the min and max values.

#min and max in a list with less than 2*N comparision in an element.

def min_max(nums):
    maxi=float('-inf')
    mini=float('inf')
    i=0
    if nums==None or len(nums)==0:
        return([])
    elif len(nums)<2:
        return([nums[0],nums[0]])
    while i<=len(nums)-2:
        if nums[i]>nums[i+1]:
            max_a,min_a=nums[i],nums[i+1]
        else:
            min_a,max_a=nums[i],nums[i+1]
        if max_a>maxi:
            maxi=max_a
        if min_a<mini:
            mini=min_a
        i=i+2
    if len(nums)%2!=0:
        maxi=max(maxi,nums[i])
        mini=min(mini,nums[i])
    return([maxi,mini])
        
nums=[1,2]
print(min_max(nums))
