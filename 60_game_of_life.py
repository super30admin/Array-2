# Time complexity - O(m * n)
# Space complexity - O(1)

# Approach - Traverse through the board counting neighbours, only catch is instead of converting 1 -> 0
# and 0 -> 1 right away, maintain another two values (say 2 and 3), and then traverse through board again
# to make changes.

from typing import List
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])

        for i in range(row):
            for j in range(col):
                liveNeigh = self.countLiveNeigh(board, i, j)

                if board[i][j] == 1:
                    if liveNeigh < 2 or liveNeigh > 3:
                        board[i][j] = 2 # 1 -> 0
                else:
                    if liveNeigh == 3:
                        board[i][j] = 3 # 0 -> 1
        
        for i in range(row):
            for j in range(col):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

    def countLiveNeigh(self, board: List[List[int]], i: int, j: int) -> int:
        row = len(board)
        col = len(board[0])
        seq = [(0, 1), (1, 0), (0, -1), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        count = 0

        for s in seq:
            r = i + s[0] # next row
            c = j + s[1] # next col
            if (r >= 0 and c >= 0 and r < row and c < col):
                if board[r][c] == 1 or board[r][c] == 2:
                    count += 1
        
        return count