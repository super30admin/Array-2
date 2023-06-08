"""
Problem : 3

Time Complexity : O(m*n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

first calculating the number of alive neighbors around a cell and then changing the state based on the rules
the value changed should be different from what used to backtrack and not confuse the state of other cells
and hence returning the original board matrix without using any additional space

"""

# Game of life

class Solution:
    def gameOfLife(self, board):

        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        # 0-1-->2
        # 1-0-->-1

        rows = len(board)
        cols = len(board[0])

        for row in range(rows):
            for col in range(cols):

                countAlive = 0
                for neighbor in neighbors:

                    r = (row + neighbor[0])
                    c = (col + neighbor[1])

                    if (r < rows and r >= 0) and (c < cols and c >= 0) and abs(board[r][c]) == 1:
                        countAlive += 1

                if board[row][col] == 1 and (countAlive < 2 or countAlive > 3):
                    board[row][col] = -1
                if board[row][col] == 0 and countAlive == 3:
                    board[row][col] = 2

        for row in range(rows):
            for col in range(cols):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0