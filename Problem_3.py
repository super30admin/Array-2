"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Problem3 (https://leetcode.com/problems/game-of-life/)
"""

class Solution:
 
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0: return
        
        m, n = len(board), len(board[0])
        # 8 neigbours for a cell
        dirs = [(-1, 0), (1,0), (0,-1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
        
        # First Pass 
        for i in range(m):
            for j in range(n):
                # count the number of live_cells for each cell
                live_cells = 0
                for cell in dirs:
                    r = (i + cell[0])
                    c = (j + cell[1])
                    
                    if (r< m and r >= 0) and (c < n and c >= 0) and (board[r][c] == 1 or board[r][c] ==2):
                        live_cells += 1
                 
                
                # Rule 1 or Rule 3
                if ((board[i][j] == 1) and (live_cells < 2 or live_cells > 3)):
                    board[i][j] = 2
                # Rule $
                if((board[i][j] == 0) and live_cells ==3 ):
                    board[i][j] = 3

        
        # Second pass
        for i in range(m):
            for j in range(n):
                    if board[i][j] == 2:
                        board[i][j] = 0
                    elif board[i][j] == 3:
                         board[i][j] = 1
                    
                    
                    
                    
        