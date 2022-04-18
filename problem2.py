#Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
# // Time Complexity : 3*N/2 = 1.5N | 3 comparision and incrementing by 2 everytime
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def findMinMax(nums):
    i=0
    mini=float('infinity')
    maxi=float('-infinity')
    while(i+1<=len(nums)-1):
        if(nums[i]<nums[i+1]):             #if i is smaller, compare i to minimum and i+1 to maximum
            mini = min(mini, nums[i])
            maxi = max(maxi, nums[i+1])
        else:
            mini = min(mini, nums[i+1])         #if i is bigger, compare i to maximum and i+1 to bigger
            maxi = max(maxi, nums[i])
        i+=2

    return (mini, maxi)

#test
print(findMinMax([1,4,2,7,6,14,23,2,6,-3,-4,3]))

