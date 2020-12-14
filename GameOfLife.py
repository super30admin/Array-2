# https://leetcode.com/problems/game-of-life/

# Approach: iterate through the array and change the value of the cells according to conditions specified. 
# 0 will be showed by 2 and 1 will be showed by 3. This helps us remember what were the old values of the matrix which we will convert back to the 0 and 1. 
# This approach will make the change in place

# Time complexity: O(m*n)
# Space complexity: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None or len(board) == 0:
            return 
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                liveCells = self.countLives(board,i,j,m,n)
                
                # Rule 1,2,3
                if(board[i][j] == 1 and (liveCells < 2 or liveCells > 3)):
                    board[i][j] = 3
                
                # Rule 4
                elif (board[i][j] == 0 and liveCells == 3):
                    board[i][j] = 2
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
       
    # Count number of live cells around given indices
    def countLives(self,board, i, j,m,n):
        count = 0
        
        # Create directions 
        dirs = [[0,-1],  
                    [-1,0], 
                    [1,0],
                    [0,1],
                    [1,1], 
                    [-1,-1],
                    [-1,1],
                    [1,-1]
                   ]
        
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            
            if (r>=0 and r<m and c>=0 and c<n and (board[r][c] == 1 or board[r][c] == 3)):
                count += 1
                
        return count
            