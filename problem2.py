# // Time Complexity : O(m*n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : Yes

class Solution(object):
    def __init(self):
        self.m = 0
        self.n = 0

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0:
            return None

        self.m = len(board)
        self.n = len(board[0])

        for i in range(0, self.m):
            for j in range(0, self.n):
                lives = self.countLives(board, i, j)
                if board[i][j] == 1:
                    if lives < 2 or lives > 3:
                        board[i][j] = 2
                else:
                    if lives == 3:
                        board[i][j] = 3

        for i in range(0, self.m):
            for j in range(0, self.n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

        return board

    def countLives(self, board, i, j):
        dirs = [[-1, -1], [0, -1], [1, -1], [-1, 0], [1, 0], [-1, 1], [0, 1], [1, 1]]
        count = 0
        for dir in dirs:
            nr = i + dir[0]
            nc = j + dir[1]

            if nr >= 0 and nr < self.m and nc >= 0 and nc < self.n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1
        return count

