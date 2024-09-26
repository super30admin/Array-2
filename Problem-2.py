"""
## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison


// Time Complexity : O(3(N-1)/2 )
// Space Complexity : constant
// Did this code successfully run on Leetcode : Unable to find the problem on leetcode
"""


# brutforce - sort the array and the return the 1st and last element of the array TIME-O(nlogn) , Space- constant
def MinAndMax1(nums):
    nums.sort()
    minimum=nums[0]
    maximum=nums[len(nums)-1]
    return minimum,maximum


#optimal 1   2(N-1) comparisons
def MinAndMax2(nums):
    minimum=nums[0]   # assign max and min to 1st element and then compare each element with min and max
    maximum=nums[0]
    for i in range(1,len(nums)):
        if nums[i]<minimum:  # if current element is less than min then current element will be new min
            minimum=nums[i]
        if nums[i]>maximum:  # if current element is greater  than max then current element will be new max
            maximum=nums[i]
    return minimum, maximum


#optimal 2  3(N-1)/2 COMPARISONS
def MinAndMax3(nums):  # we take numbers in pairs and compare like 2nd and 3rd element and compare them
    minimum=nums[0]   # assign max and min to 1st element and then compare each element with min and max
    maximum=nums[0]
    for i in range(1,len(nums),2):
        if len(nums)%2==0 and i==len(nums)-1:   # if we are left with 1 element in last after pairing
            G=nums[len(nums)-1]
            L=nums[len(nums)-1]

        else:
            if (nums[i] > nums[i+1]):
                G=nums[i]
                L=nums[i+1]
            else:
                L = nums[i]
                G = nums[i + 1]

        maximum=max(maximum,G)
        minimum=min(minimum,L)
    return minimum,maximum



print(MinAndMax1([2,8,6,2,11,5,70,]))
print(MinAndMax2([2,8,6,2,11,5,70]))
print(MinAndMax3([2,8,6,2,11,5,70,90]))