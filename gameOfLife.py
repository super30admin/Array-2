class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # Time Complexity: O(mn)
        # Space Complexity: O(1)
        m = len(board) - 1
        n = len(board[0]) - 1

        def helper(x, y):
            directions = [(1, 1), (-1, -1), (0, 1), (0, -1), (1, 0), (-1, 0), (-1, 1), (1, -1)]
            count1 = 0
            for r, c in directions:
                nr = x + r
                nc = y + c
                if m >= nr >= 0 and n >= nc >= 0 and (board[nr][nc] in (1,2) ):
                    count1 = count1 + 1
            if board[x][y] == 0 and count1 == 3:
                board[x][y]=3
            elif (count1 < 2 or count1 > 3) and board[x][y] == 1:
                board[x][y]=2

        for i in range(m + 1):
            for j in range(n + 1):
                helper(i, j)
        for i in range(m + 1):
            for j in range(n + 1):
                if board[i][j]==3:
                    board[i][j]=1
                elif board[i][j]==2:
                    board[i][j]=0
                    