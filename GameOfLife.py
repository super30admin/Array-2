# TC: O(m x n)
# SC: O(1)
# LeetCode: Y(https://leetcode.com/problems/game-of-life/)
# Approach: Record dead to live as 2, live to dead as 3
#           Do this to identify the information of live and dead cells in current state, and next state

class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
    # 0 => 1 (2)
    # 1 => 0 (3)
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.m = len(board)
        self.n = len(board[0])
        
        # check board dimensions
        if board == None or self.m == 0 or self.n == 0:
            return
        
        # Loop through the board row by row cell by cell
        for row in range(len(board)):
            for col in range(len(board[0])):
                # live cell will die because of under-population or over-population
                if board[row][col] == 1 and (self.countNeighboringLiveCells(board, row, col) < 2 or self.countNeighboringLiveCells(board, row, col) > 3):
                    board[row][col] = 3
                # dead cell will become alive 
                elif board[row][col] == 0 and self.countNeighboringLiveCells(board, row, col) == 3:
                    board[row][col] = 2
                    
        for row in range(len(board)):
            for col in range(len(board[0])):
                # recover live cell
                if board[row][col] == 2:
                    board[row][col] = 1
                # recover dead cell
                elif board[row][col] == 3:
                    board[row][col] = 0
                    
                
    def countNeighboringLiveCells(self, board, i, j):
        directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
        
        neighboring_live_cells = 0
        
        for direction in directions:
            neighbor_row = i + direction[0]
            neighbor_col = j + direction[1]
            
            if neighbor_row >= 0 and neighbor_row < self.m and neighbor_col >= 0 and neighbor_col < self.n:
                
                if board[neighbor_row][neighbor_col] == 1 or board[neighbor_row][neighbor_col] == 3:
                    neighboring_live_cells += 1
                
        return neighboring_live_cells
