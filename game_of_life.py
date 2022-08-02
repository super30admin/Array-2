class Solution:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        #1 --> 0 --> 2 
        #0 --> 1 -->3
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                live_neighbours=self.count_cells(board,i,j)
                
                #check first condition and third condition
                if board[i][j]==0:
                    if live_neighbours==3:
                        board[i][j]=2 
                #check fourth condition        
                else:
                    if live_neighbours<2 or live_neighbours>3:
                        board[i][j]=3
         #now change back to the resultant values             
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=1
                if board[i][j]==3:
                    board[i][j]=0
     
    #function to calculate neighbours
    def count_cells(self,board,i,j):
        count=0
        dirs=[[0,-1],[0,1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        
        for d in dirs:
            new_row=i+d[0]
            new_col=j+d[1]
            
            if new_row>=0 and new_row<len(board) and new_col>=0 and new_col<len(board[0]):
                if board[new_row][new_col]==1 or board[new_row][new_col]==3:
                    count+=1
            
        return count