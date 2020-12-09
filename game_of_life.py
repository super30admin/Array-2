'''
TC:O(M*N)
SC:O(1)
'''

class Solution(object):
    def gameOfLife(self, board):
        m = len(board)
        n = len(board[0])

        if m == 0 or n == 0:
            return 
        for iM in range(m):
            for iN in range(n):
                numNeighbor = sum([board[i][j]%2 for i in range(iM-1,iM+2) for j in range(iN-1,iN+2) if 0 <= i < m and 0<= j < n]) - board[iM][iN]
                if board[iM][iN] == 0 and numNeighbor == 3:
                    board[iM][iN] = 2
                if board[iM][iN] == 1 and ( numNeighbor < 2 or numNeighbor >  3):
                    board[iM][iN] = 3
        for iM in range(m):
            for iN in range(n):
                if board[iM][iN] == 2:
                    board[iM][iN] = 1
                if board[iM][iN] == 3:
                    board[iM][iN] = 0


board = [[0,1,0],
    [0,0,1],
    [1,1,1],
    [0,0,0]]
Solution().gameOfLife(board)
print(board)
