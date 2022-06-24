'''
- Passed testcases on leetcode
'''
class Solution:

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        # O(m*n) Time Complexity ; O(1) Space Complexity
        m = len(board)
        if (board == None or m == 0):
            return
        n = len(board[0])

        for r in range(m):
            for c in range(n):
                Ones = self.Ones(board, m, n, r, c)
                if (board[r][c] == 1 and (Ones < 2 or Ones > 3)):
                    board[r][c] = 2
                if (board[r][c] == 0 and Ones == 3):
                    board[r][c] = 3

        for r in range(m):
            for c in range(n):
                if (board[r][c] == 2):
                    board[r][c] = 0
                if (board[r][c] == 3):
                    board[r][c] = 1

        return

    def Ones(self, board, m, n, r, c):

        # O(1) Time Complexity | O(1) Space Complexity
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1],
                [-1, -1], [-1, 1], [1, -1], [1, 1]]
        cnt = 0

        for i in directions:
            row = r + i[0]
            col = c + i[1]
            if (row >= 0 and row < m and col >= 0 and col < n):
                if (board[row][col] == 1 or board[row][col] == 2):
                    cnt += 1

        return cnt
