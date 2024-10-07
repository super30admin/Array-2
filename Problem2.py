# Time Complexity (TC): O(m * n), where m is the number of rows and n is the number of columns.
#    - We visit each cell in the grid once to count the neighbors, resulting in O(m * n).
# Space Complexity (SC): O(1) since the board is modified in place and no extra space is used apart from variables.

# Approach:
# Original | New | State
#    0     |  0  |  0
#    1     |  0  |  1
#    0     |  1  |  2
#    1     |  1  |  3

# 1. For each cell in the board, count its neighbors that are alive (including cells that are marked as "will die").
#    - We use the `countNeighbours` helper function to count neighbors by iterating over the 8 possible neighbors.
# 2. To mark state transitions:
#    - Mark a live cell (1) that stays alive as 3 (will stay alive).
#    - Mark a dead cell (0) that becomes alive as 2 (will become alive).
# 3. After processing the board, go through it again and finalize the state transitions:
#    - Convert cells marked as 3 back to 1 (alive).
#    - Convert cells marked as 2 to 1 (alive).
#    - Convert live cells (1) that should die to 0.
class Solution(object):
    def gameOfLife(self, board):
        ROWS, COLS = len(board), len(board[0])

        def countNeighbours(r, c):
            nei = 0
            for i in range(r-1, r+2):
                for j in range(c-1, c+2):
                    if ((i == r and j == c) or i < 0 or j < 0 or i == ROWS or j == COLS):
                        continue
                    if board[i][j] in [1, 3]:
                        nei += 1
            return nei

        for r in range(ROWS):
            for c in range(COLS):
                nei = countNeighbours(r, c)
                if board[r][c]:
                    if nei in [2, 3]:
                        board[r][c] = 3
                else:
                    if nei == 3:
                        board[r][c] = 2

        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == 1:
                    board[r][c] = 0
                elif board[r][c] in [2, 3]:
                    board[r][c] = 1
