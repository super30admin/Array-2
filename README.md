# Array-2
## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
# Get the index of the element and check if a positive integer exists. Make the number negative.
# Get the numbers which are positive and store the index of those numbers. 
# As the difference between the number and its index is '1'. We get the missing numbers from the 
# positive number indices.

## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
# Initialize min and max number as '0'
# Parse the array, if number is less than the next number we compare the min with current number and max
# with the next number
# Else we compare the min with next number and max with the current number
# Return min and max number

## Problem3 (https://leetcode.com/problems/game-of-life/)
# Perfrom in place functions, if the cell is updating from 0 to 1 then we assign it '2' and if it
# goes from 1 to 0 then we assign it '3'.
# Perform another traversal to update the cell so that we can check for its neighbours and determine
# if the cell is alive or not by updating it to '0' or '1'.
# Return the updated board. 
