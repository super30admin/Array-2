# Explain your approach in three sentences only at top of your code
# Approach: Use in-place encoding by marking live cells that will die as -1 and dead cells that will become live as 2, so we can distinguish original values from updated values in a single pass. 
# For each cell, check its 8 neighbors and apply the Game of Life rules based on the initial values. Finally, perform a second pass to decode the board by converting -1 back to 0 and 2 back to 1.

# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns, since each cell and its neighbors are examined once.
# Space Complexity: O(1), as no extra space is used beyond modifying the input in place.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # Directions to check the eight neighboring cells
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        rows, cols = len(board), len(board[0])
        
        # Helper function to count live neighbors for a given cell
        def count_live_neighbors(row, col):
            live_neighbors = 0
            for dr, dc in directions:
                r, c = row + dr, col + dc
                if 0 <= r < rows and 0 <= c < cols and abs(board[r][c]) == 1:
                    live_neighbors += 1
            return live_neighbors

        # Apply the Game of Life rules using in-place encoding
        for row in range(rows):
            for col in range(cols):
                live_neighbors = count_live_neighbors(row, col)
                
                # Rule 1 & 3: Any live cell with fewer than two or more than three live neighbors dies
                if board[row][col] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[row][col] = -1  # 1 -> 0

                # Rule 4: Any dead cell with exactly three live neighbors becomes live
                if board[row][col] == 0 and live_neighbors == 3:
                    board[row][col] = 2  # 0 -> 1

        # Final pass to decode the board
        for row in range(rows):
            for col in range(cols):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0
