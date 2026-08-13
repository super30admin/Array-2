#Time Complexity: O(m*n)
#Space Complexity: O(1)

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
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
        