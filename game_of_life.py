# Approach:
# Count live neighbors for each cell using 8 directions and update the state in-place using markers:
# -1 means the cell was alive and is now dead, 2 means the cell was dead and is now alive.
# After processing all cells, normalize the board.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        rows, cols = len(board), len(board[0])
        directions = [(-1, -1), (-1, 0), (-1, 1),
                      (0, -1),          (0, 1),
                      (1, -1),  (1, 0),  (1, 1)]

        def countLiveNeighbors(r, c):
            count = 0
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and abs(board[nr][nc]) == 1:
                    count += 1
            return count

        for r in range(rows):
            for c in range(cols):
                live_neighbors = countLiveNeighbors(r, c)

                if board[r][c] == 1:
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[r][c] = -1  # Alive → Dead
                else:
                    if live_neighbors == 3:
                        board[r][c] = 2   # Dead → Alive

        for r in range(rows):
            for c in range(cols):
                if board[r][c] > 0:
                    board[r][c] = 1
                else:
                    board[r][c] = 0

# Time Complexity: O(m * n)
# Space Complexity: O(1)
