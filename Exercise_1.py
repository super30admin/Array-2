# ## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
# // Time Complexity :O(2n =O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

def findDisappearedNumbers(nums):
    # creating a result array to store result
    result = []
    # iterating through the array
    for i in range(len(nums)):
        # finding new index
        new_idx = abs(nums[i]) - 1
        # checking if positive
        if nums[new_idx] > 0:
            # making it negative
            nums[new_idx] *= -1
    # iterating through the array again
    for i in range(len(nums)):
        # if positive idx+1 element not present
        if nums[i] > 0:
            # appending to result
            result.append(i+1)
        else:
            # changing back to positive
            nums[i] *= -1
    return result


nums = [4, 3, 2, 7, 8, 2, 3, 1]
print(findDisappearedNumbers(nums))


# S1: Read Question
# S2: Constraints
# S3: Test Cases
# [7, 6, 4, 2, 1] --> [3,5]
# S4: Solution without code
# Brute Force: sort it --> send back which element is missing O(n2)
# hashset --> send back missing element O(n) O(n)
# S5: Solution without Code
# go through each element --> change all to -ve
# if not change to -ve and go to the index of that nums[idx]
# S6: Code
