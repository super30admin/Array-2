# Time Complexity : O(m * n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : At each cell, count number os live neighbors.
# Mark transitions with values: 2 (alive -> dead) and 3 (dead -> alive).
# in the final result, convert 2 -> 0 and 3 -> 1.


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        rows, cols = len(board), len(board[0])

        def getCount(i, j):
            count = 0
            for dx, dy in dirs:
                r, c = i + dx, j + dy
                if 0 <= r < rows and 0 <= c < cols:
                    if board[r][c] == 1 or board[r][c] == 2:
                        count += 1
            return count

        for i in range(rows):
            for j in range(cols):
                count = getCount(i, j)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
                elif board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        