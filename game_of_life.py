""" 
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Time Complexity: O(m*n)
Space Complexity: O(1)
"""

def gameOfLife(board):
    
    dirs = [(0,1), (0,-1), (1,0), (-1,0), (1,1), (1,-1), (-1,1), (-1,-1)]
    
    m, n = len(board), len(board[0])
    
    for i in range(m):
        for j in range(n):
            
            live = 0
            
            for dir in dirs:
                x, y = i + dir[0], j + dir[1]
                
                if 0 <= x < m and 0 <= y < n and abs(board[x][y]) == 1:
                    live += 1
                    
            if board[i][j] == 1 and (live < 2 or live > 3):
                board[i][j] = -1
                
            if board[i][j] == 0 and live == 3:
                board[i][j] = 2
                
    for i in range(m):
        for j in range(n):
            if board[i][j] > 0:
                board[i][j] = 1
            else:
                board[i][j] = 0
                
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
gameOfLife(board)
print(board)