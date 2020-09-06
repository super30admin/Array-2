# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

#Have a direction flag to change the workflow and check for boundary conditions. Rest is just changing row and column index

class Solution(object):
    def countAlive(self, row, col, m , n , board):
        count = 0
        dirs = [[1,-1], [1,0], [1,1], [0,-1], [0,1], [-1,1], [-1,0], [-1,-1]]
        
        for d in dirs:
            r = row + d[0]
            c = col + d[1]
            
            if (0 <= r < m and 0 <= c < n and (board[r][c] == 1  or board[r][c] == '#')):
                count += 1
        return count
    
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if len(board) == 0 or len(board[0]) == 0:
            return
        
        m, n = len(board), len(board[0])
        
        for i in range(m):
            for j in range(n):
                alive = self.countAlive(i, j, m, n, board)
                
                if board[i][j] == 1 and (alive < 2 or alive > 3):
                    board[i][j] = '#'
                elif board[i][j] == 0 and alive == 3:
                    board[i][j] = '*'
                
        for i in range(m):
            for j in range(n):
                if board[i][j] == '#':
                    board[i][j] = 0
                elif board[i][j] == '*':
                    board[i][j] = 1
        