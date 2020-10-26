# Time Complexity: O(m*n) - dimentions of matrix
# Space Complexity: O(1)
# Did it run on Leetcode: Yes
# Approach:
# Iterate over every element of the matrix
# Get all the neighbors and check how many are live (1)
# Follow the rules in the question
# If an element gets updated, update it to 'D' (was live, updated to dead) or 'L' (vice versa)
# We use D/L for updates since we don't want the updates to affect the result of the subsequent elements.
# Iterate over all the elements a second time and update D -> 0 and L -> 1

class Solution(object):

    def getNeighbors(self, r, c, rows, cols):
        for x, y in ((1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1)):
            nr = r + x
            nc = c + y
            if 0 <= nr < rows and 0 <= nc < cols:
                yield nr, nc

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])

        for r in range(rows):
            for c in range(cols):
                live = 0
                for nr, nc in self.getNeighbors(r, c, rows, cols):
                    if board[nr][nc] == 1 or board[nr][nc] == 'D':
                        live += 1

                # Rule 1, Rule 3
                if board[r][c] == 1 and (live < 2 or live > 3):
                    board[r][c] = 'D'
                # Rule 4
                if board[r][c] == 0 and live == 3:
                    board[r][c] = 'L'

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 'D':
                    board[r][c] = 0
                if board[r][c] == 'L':
                    board[r][c] = 1
