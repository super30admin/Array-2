# Time Complexity : O(m * n) where m is rows and n is columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use special values to encode state transitions: 0->1 as 2, 1->0 as 3.
# First pass: count live neighbors and mark transitions using special values.
# Second pass: convert special values to final states (2->1, 3->0).

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return
        
        m, n = len(board), len(board[0])
        
        # Directions for 8 neighbors
        directions = [(-1, -1), (-1, 0), (-1, 1),
                     (0, -1),           (0, 1),
                     (1, -1),  (1, 0),  (1, 1)]
        
        def countLiveNeighbors(row, col):
            count = 0
            for dr, dc in directions:
                r, c = row + dr, col + dc
                if 0 <= r < m and 0 <= c < n:
                    # Count original live cells (1 or 3 which means was alive)
                    if board[r][c] == 1 or board[r][c] == 3:
                        count += 1
            return count
        
        # First pass: mark transitions
        # 0 -> 1: mark as 2 (dead becomes alive)
        # 1 -> 0: mark as 3 (alive becomes dead)
        for i in range(m):
            for j in range(n):
                live_neighbors = countLiveNeighbors(i, j)
                
                if board[i][j] == 1:  # Currently alive
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[i][j] = 3  # Will die
                else:  # Currently dead
                    if live_neighbors == 3:
                        board[i][j] = 2  # Will become alive
        
        # Second pass: convert special values to final states
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1  # Dead becomes alive
                elif board[i][j] == 3:
                    board[i][j] = 0  # Alive becomes dead
