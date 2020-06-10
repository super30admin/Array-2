# Time Complexity : Add - O(n), Reduces #comparisons to O(1.5n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : N.A

'''
1. I am iterating the given list 2 at a time, then comapring each for min and max, then each of them with
   global min, max

'''

def min_max(nums):

    if nums == [] or len(nums) < 1:
        return

    min_ = nums[0]
    max_ = nums[0]

    #Iterating one pair(two number at a time)
    for i in range(0,len(nums)-1 ,2):

        if nums[i] < nums[i+1]:
            
            min_1 = nums[i]
            max_1 = nums[i+1]
            
        else:
            
            min_1 = nums[i+1]
            max_1 = nums[i]
            
        if min_1 < min_:
            min_ = min_1
        
        if max_1 > max_:
            max_ = max_1
            


    return min_, max_