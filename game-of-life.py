'''

TC: O(n*m)
SC: O(1)

Intuition: if 1 is changed, use 1 -> 3 to indicate change, if 0 if changed, use 0 -> 2 to indicate the same.
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rlen = len(board)
        if not rlen:
            return []
        clen = len(board[0])
        
        def isSafe(x, y, rlen, clen):
            if x < rlen and x >= 0 and y < clen and y >= 0:
                return True
            return False
        
        def countAlive(x, y, rlen, clen, mat):
            c = 0
            dirs = [(0, 1), (0, -1), (1, 1), (-1, -1), (-1, 1), (1, -1), (1, 0), (-1, 0)]
            for (i, j) in dirs:
                newx = x + i
                newy = y + j
                if isSafe(newx, newy, rlen, clen) and (mat[newx][newy] == 1 or mat[newx][newy] == 3):
                    c += 1
                    
            return c
        
        for i in range(rlen):
            for j in range(clen):
                aliveCount = countAlive(i, j, rlen, clen, board)
                if board[i][j] == 1:
                    if aliveCount < 2 or aliveCount > 3: 
                        board[i][j] = 3
                else:
                    if aliveCount == 3:
                        board[i][j] = 2
        
        for i in range(rlen):
            for j in range(clen):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
