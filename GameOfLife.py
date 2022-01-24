"""
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison

"""

# Time Complexity : O(m*n) m = row, n = col of board
# Space Complexity : O(1) result array returned
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No 

from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None:
            return
        
        m = len(board)
        n = len(board[0])
        
        for i in range(0, m):
            for j in range(0, n):
                
                cAlive = self.countAlive(board, i, j, m, n)
                
                if (board[i][j] == 1 and (cAlive < 2 or cAlive > 3)):
                    board[i][j] = 2
                
                if board[i][j] == 0 and cAlive == 3:
                    board[i][j] = 3
                    
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
                
            
    def countAlive(self, board, i, j, m, n):
        result = 0
        dirs = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        c = 0
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            
            if r >= 0 and c >= 0 and r < m and c < n and (board[r][c] == 1 or board[r][c] == 2):
                result += 1
        return result
            
        