
#Time complexity -O(M*N)
#space complexity -O(1)
# Approach - after counting thelive cells based on rules live cell that is going to be dead is replaced with -1 and dead cell that is going to be alive is replaced with 2. In the end -1 is replaced with 0 and 2 is replaced with 1.

#didn't pass the test cases. Have to figure it out for the error. 




class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        #edge case
        if board== [[]] and len(board) is None : 
            return  # we wre returning the original board
        m=len(board)
        n=len(board[0])
        
        for i in range(m):
            for j in range(n):
                livecount=self.livecount(board,i,j)
                
                #rule 1 and 3
                
                if (board[i][j]==1 and livecount<2) or(board[i][j]==1 or  livecount >3):
                    board[i][j]=-1
                    
                #rule 4
                if (board[i][j]==0 and livecount==3):
                    board[i][j]==2
                    
        #now replacing 2 with 0 and -1 with 1
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=1
                elif board[i][j]==-1:
                    board[i][j]=0
    
                     
    def livecount(self,board,i,j):
        m=len(board)
        n=len(board[0]) 
        count=0
        
        if (i!=0):
            #vertical up
            if (board[i-1][j]==1 or  board[i-1][j]==-1):
                count=count+1
        if (i!=m-1):
                #vertical down
            if (board[i+1][j]==1 or board[i+1][j]==-1):
                  count=count+1
           #horijontal left
        if (j!=0):
                #horizontal left
            if (board[i][j-1]==1 or board[i][j-1]==-1):
                count=count+1
        if (j!=n-1):
                #horizontal right
            if (board[i][j+1]==1 or  board[i][j+1]==-1):
                count=count+1
            #diagonal up right
        if (i!=0 and j!=n-1):
            if (board[i-1][j+1]==1 or  board[i-1][j+1]==-1):
                count=count+1
            #diagonal up left
        if (i!=0 and j!=0):
            if (board[i-1][j-1]==1 or board[i-1][j-1]==-1):
                count=count+1
            #diagonal down right
        if (i!=m-1 and j!=n-1):
            if (board[i+1][j+1]==1 or board[i+1][j+1]==-1):
                count=count+1
            #diagonal down left
        if (i!=m-1 and j!=0):
            if (board[i+1][j-1]==1 or board[i+1][j-1]==-1):
                count=count+1
        return count
            
            
                
            
        