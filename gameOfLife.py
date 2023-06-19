# Space Complexity: O(1) 
# Time Complexity:  O(n)
from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        rows = len(board)
        cols = len(board[0])
        dirs = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]

        for r in range(rows):
            for c in range(cols):
                liveCount = 0
                for d in dirs:
                    nr, nc = r+d[0], c+d[1]
                    if 0 <= nr < rows and 0 <= nc < cols and (board[nr][nc] == 1 or board[nr][nc] == 3):
                            liveCount += 1
                
                if board[r][c] == 1 and (liveCount < 2 or liveCount > 3):
                    board[r][c] = 3
                elif board[r][c] == 0 and liveCount == 3:
                    board[r][c] = 2

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 2:
                    board[r][c] = 1
                elif board[r][c] == 3:
                    board[r][c] = 0

                    

                


        