"""
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
"""

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        # Traverse through every elem and check all neighbours and follow the rules
        # Run Time Complexity : O(M*N)
        # Space Complexity :O(1)
        # 2 indicates 0 -> 1
        # 3 indicates 1 -> 0
        row = len(board)
        col = len(board[0])
        for i in range(row):
            for j in range(col):
                l = self.find_neighbours(board, i, j)
                if l < 2 and board[i][j]==1:
                    board[i][j] = 3
                    
                elif l > 3 and board[i][j] == 1:
                    board[i][j] = 3
                
                elif (l == 2 or l == 3) and board[i][j] == 1:
                    board[i][j] = 1
                
                elif l == 3 and board[i][j]==0:
                    board[i][j] = 2
        
        for i in range(row):
            for j in range(col):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == 3:
                    board[i][j] = 0
        
        return board
                
        
    def find_neighbours(self, board, row, col):
        live_neighbours = 0
        dire = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for dir in dire:
            new_row = row + dir[0]
            new_col = col + dir[1]
        
            if (new_col>= 0 and new_col<len(board[0]) and new_row >=0 and new_row < len(board)):
                if(board[new_row][new_col] == 1 or board[new_row][new_col] == 3):
                    live_neighbours += 1

        
        return live_neighbours