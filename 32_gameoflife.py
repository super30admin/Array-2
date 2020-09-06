# S30 Big N Problem #32 {Medium}

# Game of Life

# Time Complexity : O(n*m) n= no. of rows, m= no. of columns
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# Traverse through the each element in matrix
# Based on the rules, if a live cell becomes dead mark it with 2
# if a dead cell becomes live mark it with 4
# replace the 2 and 4 with appropriate values 


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m=len(board)
        n=len(board[0])
        
        
        for i in range(0,m,1):
            for j in range(0,n,1):
                
                live=0
                
                #left
                if j-1>=0 and (board[i][j-1]==1 or board[i][j-1]==2):
                    live+=1
                    
                #right
                if j+1<n and (board[i][j+1]==1 or board[i][j+1]==2):
                    live+=1
                
                #up
                if i-1>=0 and (board[i-1][j]==1 or board[i-1][j]==2):
                    live+=1
                
                #down
                if i+1<m and (board[i+1][j]==1 or board[i+1][j]==2):
                    live+=1
                
                #diag left top
                if (j-1>=0 and i-1>=0) and (board[i-1][j-1]==1 or board[i-1][j-1]==2):
                    live+=1
                    
                #diag right top
                if (j+1<n and i-1>=0) and (board[i-1][j+1]==1 or board[i-1][j+1]==2):
                    live+=1
                
                #diag bottom left 
                if (j-1>=0 and i+1<m) and (board[i+1][j-1]==1 or board[i+1][j-1]==2):
                    live+=1
                
                #diag bottom right 
                if (j+1<n and i+1<m) and (board[i+1][j+1]==1 or board[i+1][j+1]==2):
                    live+=1
                
                if live<2 and (board[i][j]==1 ):
                    board[i][j]=2
                
                elif live>3 and (board[i][j]==1 ):
                    board[i][j]=2
                elif live==3 and (board[i][j]==0 ):
                    board[i][j]=4
        
        for i in range(0,m,1):
            for j in range(0,n,1):
                
                if board[i][j]==4 :
                    board[i][j]=1
                elif board[i][j]==2:
                    board[i][j]=0
                    
        
        return board
                
                
                    
                
                
        