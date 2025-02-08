# Problem 3 -  Game of Life
# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
The challenge was to come up with a method of using a temporary value when updating elements based on a condition, in order to 
preserve the original value for future processing. Since we're modifying the array in place, it's important to ensure that we 
can still reference the initial values of the array to determine the element's state according to the condition.
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS = len(board)
        COLS = len(board[0])

        # Function to count the alive neighbours for the element at row and col postion
        def countNeighbours(row, col):
            count = 0 
            # Storing the direction index of the neighbouring elements
            directions = [[0,1], [0, -1], [1,0], [-1, 0], [1, 1], [-1, -1], [-1, 1], [1, -1]]
            for r, c in directions:
                rr = r + row
                cc = c + col
                if (0 <= rr < ROWS and 0 <= cc < COLS and (board[rr][cc] == 1 or board[rr][cc] == 2)):
                    count += 1
            return count
        
        for i in range(ROWS):
            for j in range(COLS):
                countA = countNeighbours(i, j)
                # Set  the value 2 or 3 as temporary number
                # Set the element as 2 (meand dead) if it is alive and it has either less than 2 or more than 3 alive neighbours
                if (board[i][j] == 1 and (countA < 2 or countA > 3)):
                    board[i][j] = 2
                # Set the element as 3 (meand alive) if it is dead and it has exactly 3 alive neighbours
                if (board[i][j] == 0 and countA == 3):
                    board[i][j] = 3
        # Again set the original element value 
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

