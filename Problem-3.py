class Solution:
    def countLives(self, board,i,j,m,n):
            dirs=[[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
            count=0
            for d in dirs:
                r=i+d[0]
                c=j+d[1]
                if (0<=r<m and 0<=c<n):
                    if board[r][c]==1 or board[r][c]==3:
                        count+=1
                    
            return count
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        if not board or len(board)==0 or len(board[0])==0:
            return [[]]
        
        m,n=len(board),len(board[0])
        #2-->dead--alive
        #3-->alive --dead
        
        for i in range(m):
            for j in range(n):
                count=self.countLives(board,i,j,m,n)   
                if ((board[i][j]==1 and (count<2 or count>3))):
                    board[i][j]=3                
                elif (board[i][j]==0 and count==3):                    
                    if count==3:
                        board[i][j]=2      
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=1
                elif board[i][j]==3:
                    board[i][j]=0
            
        
            
        
        