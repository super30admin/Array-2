# Time Complexity - O(N) where N = m*n

# Space Complexity - O(1)

# Did this code successfully run on Leetcode : No

# Any problem you faced while coding this : No

# Approach
# I use state change approach where where transition from dead to live cell is stored as 3 and transition from
# live to dead cell is stored as 2. For each cell I count the number of live cells among its immediate neighbours
# and then apply it to the given cases. At the end I substitute all all 3 with and 2 with 0.

class Solution:
    def helper(self, board, i, j, m, n):
        direction = [[0, 1], [0, -1], [-1, 0], [1, 0], [1, 1], [-1, 1], [1, -1], [-1, -1]]
        count = 0
        for z in range(len(direction)):
            r = i + direction[z][0]
            c = j + direction[z][1]
            if r >= 0 and r <= m - 1 and c >= 0 and c <= n - 1 and (board[r][c] == 1 or board[r][c] == 2):
                count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                liveCells = self.helper(board, i, j, m, n)
                if (board[i][j] == 1 and (liveCells < 2 or liveCells > 3)):
                    board[i][j] = 2
                elif board[i][j] == 0 and liveCells == 3:
                    board[i][j] = 3

        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == 3:
                    board[i][j] = 1
                elif board[i][j] == 2:
                    board[i][j] = 0

