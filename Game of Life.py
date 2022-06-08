""""// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def gameOfLife(self, board):
        m = len(board)
        n = len(board[0])
        if not board or len(board) == 0:
            return
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        # 0-->1:2
        # 1-->0:3
        for i in range(m):
            for j in range(n):
                countAlive = self.countA(board, dirs, i, j)
                if board[i][j] == 1 and (countAlive < 2 or countAlive > 3):
                    board[i][j] = 3
                if board[i][j] == 0 and (countAlive == 3):
                    board[i][j] = 2

        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1

    def countA(self, board, dirs, i, j):
        m = len(board)
        n = len(board[0])
        result = 0
        for k in dirs:
            nr = i + k[0]
            nc = j + k[1]
            if nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3):
                result += 1
        return result
Obj=Solution()
print(Obj.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))
