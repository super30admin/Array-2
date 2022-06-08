# Time Complexity: O(m*n)
# Space Complexity: O(1)
  
class Solution:
    def countAlive(self, board, i, j, dirs):
        result = 0
        m = len(board)
        n = len(board[0])
        for dir in dirs:
            nr = i+dir[0]
            nc = j+dir[1]
            if  (nr >=0 and nr < m) and (nc >= 0 and  nc < n) and (board[nr][nc] == 1 or board[nr][nc] == 2):
                result += 1
        return result
            
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        dirs = [[0,1], [0,-1], [1,0], [-1,0], [-1,-1], [-1, 1], [1, -1], [1,1]]
        
        for i in range(m):
            for j in range(n):
                countAlive = self.countAlive(board, i, j, dirs)
                if board[i][j] == 1 and (countAlive < 2 or countAlive > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and (countAlive == 3):
                    board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
                    
                
