# Problem3 (https://leetcode.com/problems/game-of-life/)

# TC : O(m×n) where m and n are the dimensions of the board

# SC : O(1) since we modify the board in-place

# Approach: 
    # In-place modification: The algorithm updates the board directly without using extra 
    #                  space for a complete copy, which is the requirement of the problem.
    # Two-pass approach:
        # First pass: Marks cells that will change state using intermediate 
        #            values (2 and 3)
        # Second pass: Converts these intermediate values to their final states
    # Careful state tracking:
        # Uses 2 to represent cells transitioning from dead (0) to alive (1)
        # Uses 3 to represent cells transitioning from alive (1) to dead (0)    
    # Boundary checking: Ensures we only check valid neighboring cells
    # Simultaneous updates: By using intermediate states, we ensure all transitions happen 
    #                      simultaneously as required by the rules of the Game of Life.

# Did this code successfully run on Leetcode : YES


def gameOfLife(self, board):
        
    if not board or not board[0]:
        return
    
    m, n = len(board), len(board[0])
    
    # Directions for all 8 neighbors (horizontal, vertical, diagonal)
    directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
    
    # First pass: Mark cells that will change state
    # We'll use 2 to represent a cell that was dead (0) but will become alive (1)
    # We'll use 3 to represent a cell that was alive (1) but will become dead (0)
    for i in range(m):
        for j in range(n):
            # Count live neighbors
            live_neighbors = 0
            for di, dj in directions:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and (board[ni][nj] == 1 or board[ni][nj] == 3):
                    live_neighbors += 1
            
            # Apply rules
            if board[i][j] == 1:  # Currently alive
                if live_neighbors < 2 or live_neighbors > 3:
                    # Rule 1 & 3: Dies due to under-population or over-population
                    board[i][j] = 3  # Mark for death (currently alive)
            else:  # Currently dead
                if live_neighbors == 3:
                    # Rule 4: Reproduction
                    board[i][j] = 2  # Mark for life (currently dead)
    
    # Second pass: Update the board with new states
    for i in range(m):
        for j in range(n):
            if board[i][j] == 2:  # Marked for life
                board[i][j] = 1
            elif board[i][j] == 3:  # Marked for death
                board[i][j] = 0
