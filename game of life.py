# TC: O(m*n)
# SC: O(1)
# The code compiled on LC successfully

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions = [(1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1)]

        for i in range(len(board)):
            for j in range(len(board[0])):
                live_neighbors = 0
                
                for x, y in directions:
                    ni, nj = i + x, j + y
                    if 0 <= ni < len(board) and 0 <= nj < len(board[0]) and abs(board[ni][nj]) == 1:
                        live_neighbors += 1

                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = -1
                elif board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0
