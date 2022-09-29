## Passed in leet code
# TC: O(N) ## Asymptotically as we are working on 8 neighbours only  
# SC: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board)==0:
            return
        m = len(board)
        n = len(board[0])
        
        ## 1-->0:2 0-->1:3
        def liveneighbour( board,i,j ):
            count=0
            dirs=[[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
            for r, c in dirs:
                nr, nc = i + r, j + c  

                if (m>nr>=0 and n>nc>=0 and (board[nr][nc]==1 or board[nr][nc]==2 )):
                    count += 1
            return count
            
        for i in range(m):
            for j in range(n):
                livecells=liveneighbour(board,i,j)
                print(livecells)
                if (board[i][j]==0):
                    if(livecells==3):
                        board[i][j]=3
                else:
                    if(livecells<2 or livecells>3):
                        board[i][j]=2
           
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1