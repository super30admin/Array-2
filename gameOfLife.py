#TimeComplexity:O(m*n)
#Space Complexity: O(1)
def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows=len(board)
        cols=len(board[0])
        for i in range(rows):
            for j in range(cols):
                aliveCount=self.countAlive(board,i,j)
                if board[i][j]==1 and (aliveCount<2 or aliveCount>3):
                    board[i][j]=-1
                elif board[i][j]==1 and (aliveCount==2 or aliveCount==3):
                    board[i][j]=1
                elif board[i][j]==0 and (aliveCount==3):
                    board[i][j]=2
        for i in range(rows):
            for j in range(cols):
                if board[i][j]==-1:
                    board[i][j]=0
                if board[i][j]==2:
                    board[i][j]=1         
                
    def countAlive(self,board,i,j):
        dirs=[(1,0),(1,1),(1,-1),(-1,-1),(-1,0),(0,1),(0,-1),(-1,1)]
        result=0
        for direction in dirs:
            r=direction[0]+i
            c=direction[1]+j
            if r>=0 and c>=0 and r<len(board) and c<len(board[0]) and (board[r][c]==1 or board[r][c]==-1):
                result+=1
        return result
                
            