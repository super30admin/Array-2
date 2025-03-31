# In-place state encoding to track transitions
# TC: O(m * n)  Iterating over each cell and its 8 neighbors
# SC: O(1)  In-place modification without extra space

from typing import List


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        # Edge case: empty board
        if not board or not board[0]:
            return

        m, n = len(board), len(board[0])

        # Helper to count live neighbors
        def countLives(board, i, j):
            directions = [
                (-1, -1),
                (-1, 0),
                (-1, 1),
                (0, -1),
                (0, 1),
                (1, -1),
                (1, 0),
                (1, 1),
            ]
            live_neighbours = 0
            for dx, dy in directions:
                ni, nj = i + dx, j + dy
                # Check for live neighbors including marked ones (1 or 3)
                if (
                    0 <= ni < m
                    and 0 <= nj < n
                    and (board[ni][nj] == 1 or board[ni][nj] == 3)
                ):
                    live_neighbours += 1
            return live_neighbours

        # State transitions:
        # 0 -> 2 (Dead -> Alive)
        # 1 -> 3 (Alive -> Dead)

        for i in range(m):
            for j in range(n):
                live_neighbours = countLives(board, i, j)
                # Alive cell dies if <2 or >3 live neighbors
                if board[i][j] == 1 and (live_neighbours < 2 or live_neighbours > 3):
                    board[i][j] = 3  # Alive -> Dead
                # Dead cell becomes alive if exactly 3 live neighbors
                if board[i][j] == 0 and live_neighbours == 3:
                    board[i][j] = 2  # Dead -> Alive

        # Final transformation: decode the board to the new state
        for i in range(m):
            for j in range(n):
                # Update from transition states
                if board[i][j] == 2:
                    board[i][j] = 1  # Dead → Alive
                elif board[i][j] == 3:
                    board[i][j] = 0  # Alive → Dead


sol = Solution()
board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
sol.gameOfLife(board)  # Modify the board in place
print(board)  # Print the modified board
