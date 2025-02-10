'''
// Time Complexity :
# Problem 1: O(n) are we parse through the entire array
# Problem 2: O(n/2) ~ O(n) are we do pair comparisons
# Problem 3: O(m*n) for the entire matrix
// Space Complexity :
# Problem 1: O(n) Worst case we will have to return close to all elements
# Problem 2: O(n) to store the array
# Problem 3: O(m*n) as we change elements of the matrix ~ O(1) auxillary space
// Did this code successfully run on Leetcode :
Yes the code ran successfully.
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
'''
## Problem 1 - Numbers disappeared in an array
# Get the index of the element and check if a positive integer exists. Make the number negative.
# Get the numbers which are positive and store the index of those numbers. 
# As the difference between the number and its index is '1'. We get the missing numbers from the 
# positive number indices.
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        result = []
        if nums == 0 or len(nums) == 0: return []
        idx = 0
        for i in range(0, n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        
        for j in range(0, n):
            if nums[j] > 0:
                result.append(j+1)
            else:
                nums[j] *= -1
        return result

## Problem 2 - Min and max of an array
# Initialize min and max number as '0'
# Parse the array, if number is less than the next number we compare the min with current number and max
# with the next number
# Else we compare the min with next number and max with the current number
# Return min and max number
 
class Solution(object):
    def minmaxNumber(self, nums):
        # Even length of array
        n = len(nums)
        # Odd length of array
        if len(nums) / 2 != 0: m = 1 
        if nums == 0 or len(nums) == 0: return [-1,-1]
        min_num = 0
        max_num = 0
        for i in range(n-1):
            if nums[i] > nums[i+1]:
                min_num = min(min_num, nums[i])
                max_num = max(max_num, nums[i+1])
            else:
                min_num = min(min, nums[i+1])
                max_num = max(max_num, nums[i])
        # Check the last element if the array is odd length        
        if(m):
            if nums[n-1] > max_num:
                max_num = nums[n-1]
            if nums[n-1] < min_num:
                min_num = nums[n-1]
        return [min_num, max_num]

## Problem 3 - Game of Life
# Perfrom in place functions, if the cell is updating from 0 to 1 then we assign it '2' and if it
# goes from 1 to 0 then we assign it '3'.
# Perform another traversal to update the cell so that we can check for its neighbours and determine
# if the cell is alive or not by updating it to '0' or '1'.
# Return the updated board. 
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count_alive = self.Countalive(board, i, j, m, n)
                if board[i][j] == 1 and (count_alive < 2 or count_alive > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and count_alive == 3:
                    board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
    
    def Countalive(self, board, i, j, m, n):
        count = 0
        dirs = [[0,1], [0,-1], [1,0], [-1,0], [-1,-1], [-1,1], [1,-1], [1,1]]
        for dir in dirs:
            n_r = i + dir[0]
            n_c = j + dir[1]
            if n_r >= 0 and n_r < m and n_c >= 0 and n_c < n:
                if board[n_r][n_c] == 1 or board[n_r][n_c] == 2:
                    count += 1
        return count
