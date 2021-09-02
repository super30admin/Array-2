# // Time Complexity :O(n*m) where n is the number of rows and m is the number of column
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                summ=self.findsum(i,j,board)
                
                if board[i][j]==1:
                    
                    if summ<2 or summ>3:
                        
                        board[i][j]=2
                
                    
                else:
                    if summ==3:
                        board[i][j]=3
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
                        

        return board
    def findsum(self,i,j,board):
        dirr=[[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        result=0
       
      
        for k in dirr:
         
            nr=i+k[0]
            nc=j+k[1]
            
            if(nr>=0 and nr<=len(board)-1 and nc>=0 and nc<=len(board[0])-1 and(board[nr][nc]==1 or board[nr][nc]==2)):
                
                result=result+1
           
        return result
            
            
            
    
                            
                        
                        