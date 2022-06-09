"""
TC: o(m x n)
SC : O(1)
"""

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[-1,-1],[1,-1],[-1,1]]
        
        for i in range(rows):
            for j in range(cols):
                live_neighbor = 0
            
                for r,c in dirs:
                    next_row = i + r
                    next_col = j + c
                    if (next_row >=0 and next_row < rows) and  (next_col >= 0 and next_col < cols) and abs(board[next_row][next_col]) == 1:
                        live_neighbor += 1

                if board[i][j] == 1 and (live_neighbor < 2 or live_neighbor > 3):
                    # 1 -> 0
                    board[i][j] = -1

                if board[i][j] == 0 and live_neighbor == 3 :
                    # 0 -> 1
                    board[i][j] = 2
        
        for i in range(rows):
            for j in range(cols):
                if board[i][j] > 0 : 
                    board[i][j] = 1
                
                else :
                    board[i][j] = 0