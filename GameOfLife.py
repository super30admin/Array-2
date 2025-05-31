# Time Complexity: O(M * N), M * N is the size of board
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes

from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        columns = len(board[0])
        for row in range(rows):
            for col in range(columns):
                live_cells = self.count_live_cells(board, row, col)
                if (board[row][col] == 1 or board[row][col] == 5) and (live_cells < 2 or live_cells > 3):
                    board[row][col] = 5
                elif (board[row][col] == 0 or board[row][col] == 4) and live_cells == 3:
                    board[row][col] = 4
        
        for row in range(rows):
            for col in range(columns):
                if board[row][col] == 5:
                    board[row][col] = 0
                elif board[row][col] == 4:
                    board[row][col] = 1
                        
                    
    def count_live_cells(self, board, row, col):
        # right, left, up, down, up-right, up-left, bottom-right, bottom-left
        directions = [(0, 1), (0, -1), (-1, 0), (1, 0), (-1, 1), (-1, -1), (1, 1), (1, -1)]

        count = 0

        for direction in directions:
            dir_row = direction[0] + row
            dir_col = direction[1] + col

            if dir_row >= 0 and dir_row < len(board) and dir_col >= 0 and dir_col < len(board[0]) and (board[dir_row][dir_col] == 1 or board[dir_row][dir_col] == 5):
                count += 1
        
        return count
