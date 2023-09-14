# TC: O(m*n)
# SC: O(m*n)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:

        r = len(board) ; c = len(board[0])
        
        for i in range(r):
            for j in range(c):
                
                live = 0
                dirs = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
                
                for d in dirs:
                    x = i + d[0] ; y = j + d[1]
                    if x>=0 and y>=0 and x<r and y<c and board[x][y] in [1, 3]:
                        live += 1
               
                if board[i][j] == 0 and live == 3:
                    board[i][j] = 2
                   
                elif board[i][j] == 1 and live != 2 and live != 3:
                    board[i][j] = 3
           
        for i in range(r):
            for j in range(c):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0