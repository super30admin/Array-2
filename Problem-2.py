# Maximum and minimum of an array using minimum number of comparisons
# https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

# Time complexiety: O(n)
# Space complexiety: O(1)

def min_max(nums):
    minInt = 100000
    maxInt = -100000

    for i in range(0,len(nums),2):
        if nums[i] > nums[i+1]:
            maxInt = max(maxInt,nums[i])
            minInt = min(minInt,nums[i+1])
        else:
            maxInt = max(maxInt,nums[i+1])
            minInt = min(minInt,nums[i])
    
    print("Min: ",minInt)
    print("Max: ", maxInt)

min_max([4,265,7,453,6,8])