# ## Problem2
# Given an array of numbers of length N, find both the minimum and maximum. Follow up :
#     Can you do it using less than 2 * (N - 2) comparison
# // Time Complexity : O(1.5n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :Yes


# // Your code here along with comments explaining your approach
def minMaxGame(nums):
    # Assign the input list to variable "l"
    l = nums
    # Continue the loop until the length of "l" is reduced to 1
    while len(l) > 1:
        # Initialize a flag "is_min" to track whether we need to take the minimum or maximum
        is_min = True
        # Initialize an empty list "tmp" to store the new values after each iteration
        tmp = []
        # Iterate over the elements of "l" with a step of 2
        for i in range(0, len(l), 2):
            # If "is_min" is True, calculate and append the minimum of the current pair
            if is_min:
                tmp.append(min(l[i:i+2]))
            # If "is_min" is False, calculate and append the maximum of the current pair
            else:
                tmp.append(max(l[i:i+2]))
            # Toggle the value of "is_min" for the next iteration
            is_min = not is_min
        # Replace the current list "l" with the new list "tmp"
        l = tmp
        # Return the last remaining element in the list
        return l[0]


nums = [1, 3, 5, 2, 4, 8, 2, 2]
print(minMaxGame(nums))
