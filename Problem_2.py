from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        directions = [
            [0, 1], [0, -1], [-1, 0], [1, 0], 
            [-1, 1], [-1, -1], [1, 1], [1, -1]
        ]
        
        m = len(board)
        n = len(board[0])

        for r in range(m):
            for c in range(n):
                live_neighbors = 0
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < m and 0 <= nc < n:
                        if board[nr][nc] == 1 or board[nr][nc] == 5:
                            live_neighbors += 1

                # Apply the rules using temporary states:
                # 1 -> 0 becomes 5 (live to dead)
                # 0 -> 1 becomes 4 (dead to live)
                if board[r][c] == 1:
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[r][c] = 5  # live to dead
                elif board[r][c] == 0:
                    if live_neighbors == 3:
                        board[r][c] = 4  # dead to live

        # Finalize the board by converting temp states to final states
        for r in range(m):
            for c in range(n):
                if board[r][c] == 5:
                    board[r][c] = 0
                elif board[r][c] == 4:
                    board[r][c] = 1
