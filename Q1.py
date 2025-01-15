####### Find all disappeared numbers


# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# if the numbers are in a range from 1 to n the corresponding position in a sorted array is located at i-1 and 
# keep negating the element at that index to indicate the value existing. Then go through array and find number which is positive
# the positive number indicates that it is the missing element

def find_disappeared(nums):
    result = []
    for i in range(len(nums)):
        index =abs( nums[i]) - 1
        nums[index] = abs(nums[index])* (-1)

    for j in range(len(nums)):
        if nums[j] > 0:
            result.append(j+1)
        else:
            nums[j] = nums[j] * (-1)
    return result


