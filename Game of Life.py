# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#temporary state change approach

# TC - O(m*n)
# SC - O(1)
#temporary state change approach
# TC - O(m*n)
# SC - O(1)
#temporary state change approach

class Solution:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #dirs = [x[:] for x in board]
        m = len(board)
        n = len(board[0])
        if board == None or m == 0:
            return
        #dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,1],[1,-1]]
        
        for i in range(0,m):
            for j in range(0,n):
                countAlive = self.countAlive(board,i,j)
                if board[i][j] == 1 and countAlive < 2 or countAlive > 3:
                    board[i][j] = 3
                if board[i][j] == 0 and countAlive == 3:
                    board[i][j] = 2
        
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
                    
                    
    def countAlive(self,board,i,j):
        res = 0
        m = len(board)
        n = len(board[0])
        dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,1],[1,-1]]
        for dir in dirs:
            nr = i+dir[0]
            nc = j+dir[1]
            if nr >= 0  and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3):
                res += 1
        return res
                
               