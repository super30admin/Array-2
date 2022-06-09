#TC: O(n)
# SC: O(1)
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        row=len(board)
        col=len(board[0])
        sum=0
        dir={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}}
        if (board==None or row==0): return
        for i in range(row):
            for j in range(col):
                if board[i][j]==1:
                    sum=count1(board,i,j)
                    if (sum<2):
                        board[i][j]=3
                    if sum>3:
                        board[i][j]=3
                if board[i][j]==0:
                    if sum==3:
                        board[i][j]=2
        for i in range(row):
            for j in range(col):
                if board[i][j]==2: board[i][j]=1
                if board[i][j]==3: board[i][j]=0
                
        def count1(board,i,j):
            sum=0
            for i in range(dir):
                nr=i+dir[0]
                nc=j+dir[1]
                if nr>=0 and nr<row and nc>=0 and nc<col and (board[nr][nc]==1 or board[nr][nc]==0):
                    sum+=1



                    

                
                    

         
        