class Solution:
    # Time Complexity - O(mn)
    # Space Complexity - O(1)
    def gameOfLife(self, board) -> None:
        m, n = len(board), len(board[0])
        #  1 --> 0  => 2
        #  0 --> 1  => 3

        lives = 0
        for i in range(m):
            for j in range(n):
                lives = self.countLives(board, i, j)
                if board[i][j] == 1:
                    if lives < 2 or lives > 3:
                        board[i][j] = 2
                else:
                    if lives == 3:
                        board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

    def countLives(self, board, r, c):
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [1, 1], [-1, -1], [-1, 1], [1, -1]]
        m, n = len(board), len(board[0])
        count = 0
        for di in dirs:
            nr = r + di[0]
            nc = c + di[1]
            if (nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                count += 1

        return count