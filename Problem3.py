# Time Complexity : O(m*n) m is rows and n is columns
# Space Complexity : O(1) inplace
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#saving the state changes in the array such that no extra spaces are used
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                c = self.liveCount(board,i,j)
                if board[i][j] == 1:
                    if c < 2 or c > 3:
                        board[i][j] = 3
                else:
                    if c == 3:
                        board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
                
    def liveCount(self,b,i,j) -> int:
        a = [[0,-1],[0,1],[-1,0],[1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        c = 0
        m = len(b)
        n = len(b[0])
        for k in a:
            x = i + k[0]
            y = j + k[1]
            if x > -1 and x < m and y > -1 and y < n and (b[x][y] == 1 or b[x][y] == 3):
                c += 1
        return c
            
            
        
        
        