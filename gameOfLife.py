# Time Complexity: O(m*n), where m = number of rows and n = number of columns
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# 1. We traverse through all the elements in the board and count alive neighbors for it.
# 2. If the cell is alive and the count of it's alive neighbors is <2, or >3 instead of making it dead (0), we mark it with a different value, -2
# 3. If the cell is dead and has exactly 3 neighbors, instead of making it alive (1), we mark it with -1
# 4. Finally, we change the intermediate state to final state by chnaging -1 to 1 and -2 to 0
from typing import List
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # -1 -> cell was dead, is alive now
        # -2 -> cell was alive, is dead now

        for i in range(len(board)):
            for j in range(len(board[0])):
                # If the cell is alive and count of its neighbors is less than 2 or greater than 3, it becomes dead 
                if board[i][j] == 1 and (self.getNeighbors(board, i, j) < 2 or self.getNeighbors(board, i, j) > 3):
                    # Instead of making it 0, we assign it an intermediate value of -2
                    board[i][j] = -2
                # If the cell is dead and the count of its neighbors is exactly 3, it becomes alive
                if board[i][j] == 0 and self.getNeighbors(board, i, j) == 3:
                    # Instead of making it alive, we assign it an intermediate value of -1
                    board[i][j] = -1

        # Convert the board from intermediate state to final state
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == -1:
                    board[i][j] = 1
                if board[i][j] == -2:
                    board[i][j] = 0

    # Get count of alive neighbors for a cell
    def getNeighbors(self, board, i, j):
        directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
        count = 0
        # Travel in all directions
        for d in directions:
            r = i + d[0]
            c = j + d[1]
            print(r, c)
            if (r < 0 or r == len(board)) or (c < 0 or c == len(board[0])):
                continue
            # If we find an alive neighbor or a neighbor that was previously alive, we increment the count of alive neighbors
            if (board[r][c] == 1 or board[r][c] == -2):
                count += 1
        return count