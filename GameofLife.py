# Time Complexity : O(m*n) where m : rows n : columns
# Space Complexity : O(1)

from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # Define directions array
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0), (-1, -1), (1, 1), (-1, 1), (1, -1)]
        
        # Iterate through the board
        for i in range(len(board)):
            for j in range(len(board[0])):
                # Count live neighbors
                live_neighbors = 0
                for direction in directions:
                    x = i + direction[0]
                    y = j + direction[1]
                    if 0 <= x < len(board) and 0 <= y < len(board[0]) and abs(board[x][y]) == 1:
                        live_neighbors += 1
                
                # Apply game of life rules
                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = -1
                elif board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 2
        
        # Update board
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0
