# Time Complexity : O(m * n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: In-place state encoding.
# Traverse the board and count live neighbors for each cell.
# Use temporary states:
# 2 → was alive (1) → becomes dead (0)
# 3 → was dead (0) → becomes alive (1)
# This allows us to preserve original state while updating.
# In the second pass, convert 2 → 0 and 3 → 1 to finalize the board.



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        m, n = len(board), len(board[0])

        def getCount(i, j):
            count = 0
            for dx, dy in dirs:
                r, c = i + dx, j + dy
                if 0 <= r < m and 0 <= c < n:
                    if board[r][c] == 1 or board[r][c] == 2:
                        count += 1
            return count

        for i in range(m):
            for j in range(n):
                cnt = getCount(i, j)
                if board[i][j] == 0 and cnt == 3:
                    board[i][j] = 3
                elif board[i][j] == 1 and (cnt < 2 or cnt > 3):
                    board[i][j] = 2

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
