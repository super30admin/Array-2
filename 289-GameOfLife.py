class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        
        rows = len(board)
        cols = len(board[0])
        
        for row in range(rows):
            for col in range(cols):
                
                # no of live neighbours 
                live = 0
                for n in neighbors:
                    
                    # row/ col of the neigh cell
                    r = (row+n[0])
                    c = (col+n[1])
                    
                    # check the validity of negihbouring cell
                    if (r<rows and r >=0) and (c<cols and c >=0) and abs(board[r][c]) == 1:
                        live +=1
                   
                # rule 1, 3
                if board[row][col] == 1 and (live < 2 or live >3):
                    board[row][col] = -1        #live cell is now dead
                   
                # rule4
                if board[row][col] == 0 and live == 3:
                    board[row][col] = 2         # previosuly dead cell is now alive
            
        # output
        for row in range(rows):
            for col in range(cols):
                
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0
                    
        

        