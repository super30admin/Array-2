"""
# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:


[4,3,2,7,8,2,3,1]



Output:


[5,6]

// Time Complexity :  0(N)
// Space Complexity :   constant
// Did this code successfully run on Leetcode :  yes



#brutforce  runtime: 0(N) , SPACE : O(N)
def Disappeared(nums):
    l=len(nums)
    hash_set=set()
    for i in range(1,l+1):
        hash_set.add(i)

    for i in range(len(nums)):
        if nums[i] in hash_set:
            hash_set.remove(nums[i])
    return [*hash_set,]     # to return set elements as list
"""
def Disappeared(nums):
    output=[]                           # output list
    for i in range(len(nums)):   # traverse the nums and go to index, which is abs(nums[i])-1
        index=abs(nums[i])-1

        if nums[index] > 0:     # if number at calculated index is positive then make it negative
            nums[index]=nums[index]* (-1)

    for i in range(len(nums)):    #loop through original nums and elments which remain positive have index +1 as misisng elements
        if nums[i]>0:
            output.append(i+1)
    return output


print(Disappeared([4,3,2,7,8,2,3,1]))

