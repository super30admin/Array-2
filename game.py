# The board is modified in place according to the game rules, where:
#   - A live cell with fewer than 2 or more than 3 live neighbors dies (underpopulation or overpopulation).
#   - A dead cell with exactly 3 live neighbors becomes a live cell (reproduction).

# Directions and Initial Setup:
#   - 'directions' is a list of 8 tuples representing the relative positions of the 8 neighboring cells for each cell.
#   - The outer loops iterate over each cell in the board by row (i) and column (j).
#   
# Neighbor Counting and Temporary State Update:
#   - For each cell (board[i][j]):
#       - Initialize 'live' to count the number of live neighbors.
#       - Check each neighboring cell in the 8 directions:
#           - If a neighbor is within bounds and is live (board[i+x][j+y] has absolute value 1), increment 'live'.
#       - Apply the game rules based on the current cell’s state and live neighbors:
#           - If the cell is live (board[i][j] == 1) and has fewer than 2 or more than 3 live neighbors, mark it as -1 (indicating it will die).
#           - If the cell is dead (board[i][j] == 0) and has exactly 3 live neighbors, mark it as 2 (indicating it will become live).
#   
# Final Update:
#   - After applying rules to all cells, another pass is made over the board:
#       - Convert temporary states to final states:
#           - Cells marked as positive (>0) become live (set to 1).
#           - Cells marked as 0 or negative are set to dead (0).

# TC: O(m * n) - Each cell and its neighbors are checked, resulting in linear time with respect to the board's size.
# SC: O(1) - The space complexity is constant as modifications are made in place on the board without extra storage.


from typing import List


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
    
        directions = [(1,0),(1,-1),(0,-1),(-1,-1),(-1,0),(-1,1),(0,1),(1,1)]
        for i in range(len(board)):
            for j in range(len(board[0])):
                live=0
                for x,y in directions: 
                    if (i+x<len(board) and i+x>=0) and (j+y<len(board[0]) and j+y>=0) and abs(board[i+x][j+y])==1:
                        live+=1
                if board[i][j]==1 and (live<2 or live>3):    
                    board[i][j]=-1
                if board[i][j]==0 and live==3:                  
                    board[i][j]=2
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j]=1 if(board[i][j]>0) else 0
        return board