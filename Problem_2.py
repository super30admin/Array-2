"""
## Problem3 (https://leetcode.com/problems/game-of-life/)
TC: O(N * M)
SC: O(1)
"""


class Solution:
    def countAlive(self, board, i, j):
        dir_dict = [(1,0),(0,1),(-1, 0), (0, -1), (1, 1), (-1, -1), (-1, 1), (1, -1)]
        m = len(board)
        n = len(board[0])
        count = 0
        
        for dirc in dir_dict:
            r, c = dirc
            
            nr = r + i
            nc = j + c
            
            if (nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc]==4)):
                count += 1
                
        return count
            
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                
                alive= self.countAlive(board, i, j)
                
                if board[i][j] == 1 and (alive < 2 or alive > 3):
                    board[i][j] = 4  # Live to dead
                    
                if board[i][j] == 0 and alive == 3:
                    board[i][j] = 3  # Dead to live
                    
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 4:
                    board[i][j] = 0
                    
                if board[i][j] == 3:
                    board[i][j] = 1
                    
                    
    
                 
        
        