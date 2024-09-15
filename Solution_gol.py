"""
Time Complexity O(N*M)

Space Complexity O(1)

Game of life rules

1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2.Any live cell with two or three live neighbors lives on to the next generation.
3.Any live cell with more than three live neighbors dies, as if by over-population..
4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Instead of copy board to update we change it on original board based on two assumption:Live to dead as -1 and dead to live as 2.


"""
class Solution_gol:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        
        rows=len(board)
        columns=len(board[0])
        
        for row in range(rows):
            for col in range(columns):
                alive_nei=0
                for nei in neighbors:
                    r= (row+nei[0])
                    c= (col+nei[1])
                    
                    if(r<rows and r>=0) and (c<columns and c>=0) and (abs(board[r][c]) == 1):
                        alive_nei += 1
                 # Rule 1 or Rule 3      
                if board[row][col] == 1 and (alive_nei < 2 or alive_nei > 3):
                    board[row][col] = -1   # -1 signifies the cell is now dead but originally was live.
                 # Rule 4     
                if board[row][col] == 0 and alive_nei == 3:
                    board[row][col] = 2 # 2 indicates the cell is live but was originally dead.
                    
        for row in range(rows):
            for col in range(columns):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0     