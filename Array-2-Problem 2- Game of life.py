"""
S30 FAANMG Problem #33 {Medium}

289. Game of Life

Time Complexity : O(MN)



Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes
    
Here We are iterating throught the board,

 for the given cases:
        1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
        2. Any live cell with two or three live neighbors lives on to the next generation.
        3. Any live cell with more than three live neighbors dies, as if by over-population.
        4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 
We will change the valoe to 2 if the Live becomes Dead
and similarly we will change the vallue to 3 when dead becomes alive

Direction array is used to maintain the directions
              
    #for Case 1 and 3 
        if(board[i][j] == 1 and (countLives < 2 or countLives>3)):
            board[i][j] =2
         
        #for Case 4
        if(board[i][j] == 0 and (countLives == 3)):
            board[i][j] = 3

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    
    def countAlive(self,board,r,c, directions):
        
        count=0
        m = len(board)
        n = len(board[0])
        
        
        for idx, dirn in enumerate (directions):
            
            nr = r + dirn[0]
            nc = c + dirn[1]
            
            if((0 <= nr < m) and (0 <= nc < n) and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                count += 1
                
        return count
                
                
                
        
        
        
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        
        m = len(board)
        n = len(board[0])
        
        if(m==0):
            return
        
        directions = [[-1,0] , [1,0] , [0,-1] , [0,1] , [-1,-1] , [-1,1] , [1,-1] , [1,1]]
        for i in range (m):
            for j in range (n):
                
                countLives = self.countAlive(board,i,j,directions)
                
                
                #for Case 1 and 3 
                if(board[i][j] == 1 and (countLives < 2 or countLives>3)):
                    board[i][j] =2
                 
                #for Case 4
                if(board[i][j] == 0 and (countLives == 3)):
                    board[i][j] = 3
                    
                    
        for i in range (m):
            for j in range (n):
                
                if (board[i][j] == 2):
                    board[i][j] = 0
                
                if (board[i][j] == 3):
                    board[i][j] = 1
        