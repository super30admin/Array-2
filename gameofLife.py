'''
Approach-->
Convert 1 to 2 if dead
Convert 0 to 3 if alive

conditions-->
if alive -->
convert to 2 if neighbours <2
stays 1 if neighbours>=1 and neighbours<=2
convert to 2 if neighbours>=3

if dead-->
convert to 3 if neighbours==3

Time Complexity-->
O(m*n)

Space Complexity -->
O(1)
'''


class Solution:
    
    def isValid(self, i, j, ROW, COL):
        if i<0 or i>=ROW or j<0 or j>=COL:
            return False
        else:
            return True
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROW = len(board)
        COL = len(board[0])
        for i in range(len(board)):
            for j in range(len(board[0])):
                val = 0
                if(self.isValid(i+1,j-1,ROW,COL)):
                    if(board[i+1][j-1] ==1 or board[i+1][j-1]==2):
                        val+=1
                if(self.isValid(i+1,j,ROW,COL)):
                    if(board[i+1][j] ==1 or board[i+1][j]==2):
                        val+=1
                if(self.isValid(i+1,j+1,ROW,COL)):
                    if(board[i+1][j+1] ==1 or board[i+1][j+1]==2):
                        val+=1
                if(self.isValid(i,j-1,ROW,COL)):
                    if(board[i][j-1] ==1 or board[i][j-1]==2):
                        val+=1
                if(self.isValid(i,j+1,ROW,COL)):
                    if(board[i][j+1] ==1 or board[i][j+1]==2):
                        val+=1
                if(self.isValid(i-1,j-1,ROW,COL)):
                    if(board[i-1][j-1] ==1 or board[i-1][j-1]==2):
                        val+=1
                if(self.isValid(i-1,j,ROW,COL)):
                    if(board[i-1][j] ==1 or board[i-1][j]==2):
                        val+=1
                if(self.isValid(i-1,j+1,ROW,COL)):
                    if(board[i-1][j+1] ==1 or board[i-1][j+1]==2):
                        val+=1
            
                #print(val)
                if board[i][j]==1 and val>3:
                    board[i][j]=2
                elif board[i][j]==1 and (val==2 or val==3):
                    board[i][j]=1
                elif board[i][j]==1 and val<2:
                    board[i][j]=2
                elif board[i][j]==0 and val==3:
                    board[i][j]=3
        #print(board)    
        for i in range(ROW):
            for j in range(COL):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
        print(board)
                
                
                
                    
                    
                    
        
    
    
    
        
        