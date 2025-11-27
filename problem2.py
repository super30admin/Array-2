"""
We use the coundary conditions to moodify the pointers and apply the games of rule accordingly, usee the temporary state change method to analyse the board
then count the changes that were made through counting the number of variations we see (2 and 3 for dead and resurrected accordingly)
TC is O(m*n) and SC is o(n)
"""


class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        def countAlive(i, j):
            count = 0
            for dr, dc in dirs:
                nr, nc = i + dr, j + dc
                if nr >= 0 and nc >= 0 and nr < m and nc < n:
                    if board[nr][nc] == 1 or board[nr][nc] == 2: #2 for originally alive, but marked to die later on
                        count += 1
            return count
        
        for i in range(m):
            for j in range(n):
                count = countAlive(i,j)
                if board[i][j] == 1 and (count > 3 or count < 2):
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0

        
       