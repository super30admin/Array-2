# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return
        m, n = len(board), len(board[0])
        directions = [
            (0, 1), (1, 0), (0, -1), (-1, 0),
            (1, 1), (1, -1), (-1, 1), (-1, -1)
        ]
        
        # First pass: mark the changes
        for i in range(m):
            for j in range(n):
                live_neighbors = 0
                for dx, dy in directions:
                    ni, nj = i + dx, j + dy
                    if 0 <= ni < m and 0 <= nj < n:
                        if board[ni][nj] == 1 or board[ni][nj] == -1:
                            live_neighbors += 1
                # Rule 1 or 3: live cell dies
                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = -1  # Mark as dead
                # Rule 4: dead cell becomes live
                if board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 2   # Mark as live
        # Second pass: finalize the board
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        