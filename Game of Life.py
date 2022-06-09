class Solution:
    m=0
    n=0
    def getCount(self,board,r,c):
        dirs=[[0,1],[0,-1],[1,0],[-1,0],[1,1],[-1,-1],[-1,1],[1,-1]]
        total=0
        for di in dirs:
            nr=r+di[0]
            nc=c+di[1]
            if nr>=0 and nr<self.m and nc>=0 and nc<self.n and (board[nr][nc]==1 or board[nr][nc]==2):
                total+=1
        return total
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        if board==None or len(board)==0:return 
        self.m=len(board)
        self.n=len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                countLiveCells=self.getCount(board,i,j)
                if board[i][j]==1:
                    if countLiveCells < 2 or countLiveCells > 3:
                        board[i][j]=2
                else:
                    if countLiveCells == 3:
                        board[i][j]=3
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1

        print(board)