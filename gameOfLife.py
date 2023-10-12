class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m = len(board) - 1
        n = len(board[0]) - 1
        changeddie = set()
        changedtolive = set()

        def helper(x, y):
            directions = [(1, 1), (-1, -1), (0, 1), (0, -1), (1, 0), (-1, 0), (-1, 1), (1, -1)]
            count1 = 0
            for r, c in directions:
                nr = x + r
                nc = y + c
                if m >= nr >= 0 and n >= nc >= 0 and board[nr][nc] == 1:
                    count1 = count1 + 1
            if board[x][y] == 0 and count1 == 3:
                changedtolive.add((x, y))
            elif (count1 < 2 or count1 > 3) and board[x][y] == 1:
                changeddie.add((x, y))

        for i in range(m + 1):
            for j in range(n + 1):
                helper(i, j)
        for x, y in changeddie:
            board[x][y] = 0
        for x, y in changedtolive:
            board[x][y] = 1
