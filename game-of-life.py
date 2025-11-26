class Solution:
    '''
    TC: O(n^2)
    SC: O(1)
    Leetcode: Completed with no issue
    issueAny problem you faced while coding this : no issue.
    '''
    def countAlive(self, board, i, j, n, m):
        count = 0
        dirs = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        for x, y in dirs:
            rx = x + i
            ry = y + j
            if 0 <= rx < n and 0 <= ry < m:
                if board[rx][ry] in [1, 2]:
                    count += 1

        return count

    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        n = len(board)
        m = len(board[0])

        for i in range(n):
            for j in range(m):
                countAlive = self.countAlive(board, i, j, n, m)
                if board[i][j] == 1:
                    if countAlive < 2 or countAlive > 3:
                        board[i][j] = 2
                else:
                    if countAlive == 3:
                        board[i][j] = 3

        for i in range(n):
            for j in range(m):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

s = Solution()
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
s.gameOfLife(board)
print(board)
board = [[1,1],[1,0]]
s.gameOfLife(board)
print(board)