# TC : O(mn)
# SC : O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows, cols = len(board), len(board[0])
        # (0,1): Move right, (1,0): Move down
        # (0,-1): Move left, (-1,0): Move up
        # (1,1): Move diagonally down-right, (-1,-1): Move diagonally up-left
        # (1,-1): Move diagonally down-left, (-1,1): Move diagonally up-right
        # This is used to find the neighbouring cells
        dirs = [(0,1), (1,0), (0,-1), (-1,0), (1,1), (-1,-1), (1,-1), (-1,1)]
        for i in range(rows):
            for j in range(cols):
                live_neighbors = 0
                for dx, dy in dirs:
                    ni, nj = i + dx, j + dy
                    if 0 <= ni < rows and 0 <= nj < cols and (board[ni][nj] == 1 or board[ni][nj] == 3):
                        live_neighbors += 1

                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = 3
                elif board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 2

                # Decode the board to get the next state
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0


        