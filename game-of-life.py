# Time Complexity : O(mn), where m is the number of rows and n is the number of columns
# Space Complexity : O(1)
# continued: That is a requirement of the problem itself
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):

                if board[i][j] == 1:

                    if self.liveCount(board, i, j, m, n) < 2:
                        board[i][j] = "live"

                    if self.liveCount(board, i, j, m, n) > 3:
                        board[i][j] = "live"

                else:

                    if self.liveCount(board, i, j, m, n) == 3:
                        board[i][j] = "dead"

        for i in range(m):
            for j in range(n):

                if board[i][j] == "live":
                    board[i][j] = 0

                elif board[i][j] == "dead":
                    board[i][j] = 1

    def liveCount(self, board, i, j, m, n):
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
        count = 0

        for d in dirs:
            row = i + d[0]
            col = j + d[1]

            if (0 <= row < m) and (0 <= col < n) and (board[row][col] == 1 or board[row][col] == "live"):
                count += 1

        return count
