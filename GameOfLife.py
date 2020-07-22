class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def countLives(board,i,j):
                count=0
                dirs=[[0,1],[0,-1],[1,0],[-1,0],[-1,1],[1,1],[1,-1],[-1,-1]]
                for dir1 in dirs:
                    r=i+dir1[0]
                    c=j+dir1[1]
                    if r>=0 and c>=0 and r<m and c<n and (board[r][c]==1 or board[r][c]==3):
                        count+=1
                return count        
        if board==None or len(board)==0:
            return 
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                lives=countLives(board,i,j)
                if board[i][j]==1:
                    if lives >3 or lives<2:
                        board[i][j]=3
                else:
                    if lives==3:
                        board[i][j]=2
        for i in range(m):
            for j in range(n):
                if board[i][j]==3:
                    board[i][j]=0
                if board[i][j]==2:
                    board[i][j]=1
        
