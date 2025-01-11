# Time Complexity = O(m*n)
# Space Complexity = O(1)
# Leetcode = yes
# Approach = recursive function to count live neighbors by checking adjacent cells in all eight possible directions. In the first pass, temporary states (2 for dead-to-live and 3 for live-to-dead) are assigned to cells based on the game's rules. In the second pass, these temporary states are finalized, updating the board in-place. This approach avoids extra space for a copy of the board by encoding transitions within the original grid

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        # Directions for neighbors
        dirs = [(-1, -1), (-1, 0), (0, -1), (1, -1), (-1, 1), (1, 0), (0, 1), (1, 1)]
        m, n = len(board), len(board[0])

        # Recursive function to count live neighbors
        def count_live_neighbors(x, y, idx=0, count=0):
            if idx == len(dirs):  # Base case: all directions processed
                return count
            dx, dy = dirs[idx]
            nx, ny = x + dx, y + dy
            if 0 <= nx < m and 0 <= ny < n and (board[nx][ny] == 1 or board[nx][ny] == 3):
                count += 1
            return count_live_neighbors(x, y, idx + 1, count)

        # First pass: Update states
        for i in range(m):
            for j in range(n):
                count = count_live_neighbors(i, j)
                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = 3  # Live to dead
                elif board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 2  # Dead to live

        # Second pass: Finalize states
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
