# Time Complexity: O(m * n) where m and n are the number of rows and columns replectively
# Space Complexity: O(1)

# The code sucessfully ran on Leetcode

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0 or board == 0:
            return 
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                liveNeighbors = self.countLiveNeighbors(board, i, j)
                
                if board[i][j] == 0:
                    if liveNeighbors == 3:
                        board[i][j] = 3
                        
                else:
                    if liveNeighbors < 2 or liveNeighbors > 3:
                        board[i][j] = 2
                
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                    
                elif board[i][j] == 3:
                    board[i][j] = 1
            
    def countLiveNeighbors(self, board, i, j):
        count = 0
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0], [-1, -1], [1, 1], [1, -1], [-1, 1]]
        m = len(board)
        n = len(board[0])
        
        for d in dirs:
            nr = i + d[0]
            nc = j + d[1]
            
            if nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1
                
        return count
    