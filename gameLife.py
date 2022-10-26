# Time Complexity: O(mn): where M is no of rows and n is number of columns
# Space Complexity: O(1) : no extra intermediate data Structure used

# Translated all 4 conditions of the Rules of Game of Life.

# Noting down Board state changes by integers 2, 3. And created a function to keep track of no. of alive neighbors.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        if board is None or m == 0:
            return
        
#         Board State Changes:
#         1 -> 0 : 3
#         0 -> 1 : 2

        for i in range(m):
            for j in range(n):
                
                aliveCount = self.aliveCount(board, i, j, m, n)
                if (board[i][j] == 1 and (aliveCount < 2 or aliveCount > 3)):
                    board[i][j] = 3
                
                if (board[i][j] == 0 and aliveCount == 3):
                    board[i][j] = 2
        
        
        for i in range(m):
            for j in range(n):
                
                if (board[i][j] == 2):
                    board[i][j] = 1
                
                if (board[i][j] == 3):
                    board[i][j] = 0
        return
        
        
    def aliveCount(self, board: List[List[int]], i: int, j: int, m: int, n: int) -> int:
        
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [1, -1], [-1, 1], [1, 1]]
        
        result = 0
        
        for dir in dirs:
            row = i + dir[0]
            col = j + dir[1]
            
            if(row >= 0 and col >= 0 and row < m and col < n and 
              (board[row][col] == 1 or board[row][col] == 3)):
                
                result += 1
                
        return result
        