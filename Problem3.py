# We put 2 if it goes from 1 -> 0 and 3 if it goes from 0 -> 3 and have a function run all 8 negihbours of each cell and check for 1 and 2 to count it as 1 and increment the count
# TC: O(m*n)
# SC: O(1)
# Yes, this worked in leetcode


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        if len(board) == 0:
            return
        for i in range(m):
            for j in range(n):
                countLive = self.countLive(board, i, j, m, n)
                if board[i][j] == 1:
                    if (countLive < 2 or countLive > 3):
                        board[i][j] = 2
                elif board[i][j] == 0:
                    if countLive == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    def countLive(self, board, i, j, m, n):
        count = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        for dir in dirs:
            nr = i + dir[0]
            nc = j + dir[1]
            if nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1
        return count
