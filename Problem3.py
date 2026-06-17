## Problem3 (https://leetcode.com/problems/game-of-life/)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        Time Complexity: O(M * N), where M is the number of rows and N is the number of columns.
                         We iterate through the entire board twice, doing a constant amount 
                         of work (checking 8 neighbors) for each cell.
        Space Complexity: O(1). We modify the board in-place using temporary state values 
                          (2 and 3) instead of creating a copy of the board.
        """
        # Define the 8 possible directions for neighboring cells (horizontal, vertical, diagonal)
        directions = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
        
        rows = len(board)
        cols = len(board[0])
        
        # We use intermediate states to track changes without losing the original state for neighbors:
        # Original 0 -> Becomes 0: keep as 0
        # Original 1 -> Becomes 1: keep as 1
        # Original 1 -> Becomes 0: mark as 2
        # Original 0 -> Becomes 1: mark as 3

        # First pass: Determine the next state for each cell
        for r in range(rows):
            for c in range(cols):
                element = board[r][c]
                liveCount = 0
                
                # Count the number of live neighbors
                for (rd, cd) in directions:
                    # Check if the neighbor is within board boundaries
                    if r + rd in range(rows) and c + cd in range(cols):
                        # A neighbor is considered "live" if it is currently 1, 
                        # or if it was originally 1 but is marked to die (2).
                        if board[r + rd][c + cd] == 1 or board[r + rd][c + cd] == 2:
                            liveCount += 1
                
                # Apply Game of Life rules based on the original state (element)
                
                # Rule 1 & 3: Any live cell with fewer than 2 or more than 3 live neighbors dies.
                if element and (liveCount < 2 or liveCount > 3):
                    board[r][c] = 2  # Mark as 2 (Live -> Dead)
                
                # Rule 4: Any dead cell with exactly 3 live neighbors becomes a live cell.
                if element == 0 and liveCount == 3:
                    board[r][c] = 3  # Mark as 3 (Dead -> Live)
                    
                # Note: Rule 2 (Live cell with 2 or 3 live neighbors lives on) requires no action 
                # because the cell remains 1.

        # Second pass: Finalize the board by updating intermediate states to their final values
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 2:
                    board[r][c] = 0  # Finalize Live -> Dead
                if board[r][c] == 3:
                    board[r][c] = 1  # Finalize Dead -> Live