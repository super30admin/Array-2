# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach:
# Iterate through the array, and multiply the value at the index corresponding to the current value in the array. As we iterate, if the value at a particular
# location is already negative, dont do anything. Lastly, (indices + 1) of positive numbers in the resulting list corresponding to missing numbers.
# add it to hashmap, and assign its value to 1.

def findDisappearedNumbers(nums):

    if len(nums) == 0:
        return []

    output = []

    for i in range(len(nums)):
        index = abs(nums[i]) - 1

        if nums[index] > 0:
            nums[index] *= -1

    for i in range(len(nums)):
        if nums[i] > 0:
            output.append(i + 1)

    return output


print(findDisappearedNumbers([4,3,2,7,8,2,3,1]))
