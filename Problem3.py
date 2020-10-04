# Time Complexity: O(N)
# Space Complexity: O(1)
# Passed Leetcode

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        x_array = [1,-1,0,0,1,-1,1,-1]
        y_array = [0,0,-1,1,-1,1,1,-1]   
        
        for i in range(m):
            
            for j in range(n):
                
                live_neighbors = 0
                for k in range(len(x_array)):
                    
                    x, y = i + x_array[k], j + y_array[k]
                    
                    if x >= 0 and y >= 0 and x < m and y < n:
                        
                        if board[x][y] == 1 or board[x][y] == -1:
                            live_neighbors += 1
                
                if board[i][j] == 1:
                    
                    if live_neighbors < 2:
                        board[i][j] = -1
                    elif live_neighbors > 3:
                        board[i][j] = -1
                else:
                    if live_neighbors == 3:
                        board[i][j] = 2
        
        for i in range(m):
            
            for j in range(n):
                
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == -1:
                    board[i][j] = 0
        
                    
                    
                    
                