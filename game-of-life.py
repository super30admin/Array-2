# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1], [1, 1], [-1, -1], [1, -1], [-1, 1]]
        
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                live_cells = self.count_live_cells(i, j, dirs, board)
                if(board[i][j] == 1 and (live_cells < 2 or live_cells > 3)):
                    # Marking live cell now dead as -1
                    board[i][j] = -1
                elif(board[i][j] == 0 and live_cells == 3):
                    # Marking dead cells now live as 2
                    board[i][j] = 2
                    
        # Updating all values
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if(board[i][j] == -1):
                    board[i][j] = 0
                elif(board[i][j] == 2):
                    board[i][j] = 1
        return board
                
    
    def count_live_cells(self, i, j, dirs, board):
        # Get live neighbors for a cell from all 8 directions
        live_cells = 0
        for dx, dy in dirs:
            x = i + dx
            y = j + dy
            
            # Taking abs(board[x][y]) since -1 indicates live cell which is now dead
            if(x < 0 or y < 0 or x >= len(board) or y >= len(board[0]) or abs(board[x][y]) != 1):
                continue
            live_cells += 1
        return live_cells