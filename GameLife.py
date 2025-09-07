# Time complexity: O(m*n)
# Space complexity: O(1) since we are doing it in-place
# Did it run on leetcode: Yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                liveCount = self.countAlive(board, i, j)
                if (board[i][j] == 1 and (liveCount < 2 or liveCount > 3)):
                    board[i][j] = 2

                if (board[i][j] == 0 and liveCount == 3):
                    board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0

                if board[i][j] == 3:
                    board[i][j] = 1

    def countAlive(self, board, i, j):
        count = 0
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

        for r, c in directions:
            nr = i + r
            nc = j + c

            if (nr >= 0 and nr < len(board) and nc >= 0 and nc < len(board[0]) and
                    (board[nr][nc] == 1 or board[nr][nc] == 2)):
                count += 1

        return count