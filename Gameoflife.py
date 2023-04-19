#Time complexity:O(mxn)
#Space complexity:O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        if board==None or len(board)==0:
            return []
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                res=self.livecount(board,i,j,m,n)
                if board[i][j]==1 and (res<2 or res>3):
                    board[i][j]=3
                elif board[i][j]==1 and (res==2 or res==3):
                    board[i][j]=1
                elif board[i][j]==0 and res==3:
                    board[i][j]=2 

        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(m):
            for j in range(n):
                if(board[i][j]==2):
                    board[i][j]=1
                if(board[i][j]==3):
                    board[i][j]=0
    def livecount(self, board: List[List[int]], i: int,j:int, m:int,n:int)->int:
        count=0
        dirs=[[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for dir in dirs:
            r=i-dir[0]
            c=j-dir[1]
            if r>=0 and r<=m-1 and c>=0 and c<=n-1 and (board[r][c]==1 or board[r][c]==3):
                count+=1
        return count
        #3-->live to dead
        #2-->dead to live