# TC: O(M x N) where M is the no. of rows of matrix and N is the cols of the matrix
# SC: O(1) since we are performing the operations on the input matrix itself

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        """
        Do not return anything, modify board in-place instead.
        """
        
#         alive --> dead = 10       1 --> 0 = 10
#         dead--> alive = 11        0 --> 1 = 11
#         1 < 2 1's --> 0
#         1 > 3 1 --> 0
#         0  == 3 1's 0--> 1d 

        rows = len(board)
        cols =len(board[0])
        
        def solveLive(board, i, j, rows, cols):
            count = countNeighbours(board, i, j, rows, cols)
            if count < 2 or count > 3:
                board[i][j] = 10
        
        def solveDead(board, i, j, rows, cols):
            count = countNeighbours(board, i, j, rows, cols)
            if count == 3:
                board[i][j] = 11
            
            
        def countNeighbours(board, i, j, rows, cols):
            lives = 0
            direc = [(1,0),(-1,0),(0,1),(0,-1),(-1,-1),(1,1),(1,-1),(-1,1)]
            for x,y in direc:
                new_x = i + x
                new_y = j + y
                
                if new_x >= 0 and new_x < rows and new_y >= 0 and new_y  < cols:
                    if board[new_x][new_y] == 1 or board[new_x][new_y] == 10:
                        lives += 1
            return lives
                    
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 1:
                    solveLive(board, i, j, rows, cols)
                else:
                    solveDead(board, i, j, rows, cols)
        
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 10:
                    board[i][j] = 0
                elif board[i][j] == 11:
                    board[i][j] = 1
    
