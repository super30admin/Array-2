#TC: O(n)
#SC: O(1)
#Approach:
#1. We take subarrays of size 2 so as to find the min and mix in those subarrays in 1 comparison for each of those subarrays. As we move forward with every subarray,
# we compare local max with global max and local min with global min to keep up with the updated min and max.
#2. This takes 3 comparisons for every subarray to find the global max and global min. Total number of comparisons come out to be 3(n/2) - 2.
def getMinAndMax(nums):
    i = 0;
    j = 1;
    global_max = float('-inf')
    global_min = float('inf')
    
    while (i < len(nums) and j < len(nums)):
        if(nums[i] > nums[j]):
            maxi = nums[i]
            mini = nums[j]
        else:
            maxi = nums[j]
            mini = nums[i]
        if(maxi > global_max):
            global_max = maxi
        if(mini < global_min):
            global_min = mini
        i += 2
        j += 2
        if i == len(nums): j -= 1
    return global_min, global_max


res = getMinAndMax([1,2,3,4,5,6,7,8,9,10])

print res
