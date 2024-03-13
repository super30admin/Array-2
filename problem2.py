# time complexity is O(RC) and space complexity is O(1)

class Solution:
    def gameOfLife(self, board):
        neighbors = [(0, 1), (1, 0), (1, 1), (-1, 0), (0, -1), (-1, -1), (1, -1), (-1, 1)]
        
        rows = len(board)
        cols = len(board[0])
        
        for row in rows:
            for col in cols:
                live_nei = 0
                
                for nei in neighbors:
                    r = (row+nei[0])
                    c = (col+nei[1])
                
                    if (r < rows and r >= 0) and (c < cols and c >=0) and abs(board[r][c]) ==1:
                        live_nei+=1
                
                if(board[row][col] ==1) and (live_nei < 2 or live_nei > 3):
                    board[row][col] = -1
                    
                if board[row][col] == 0 and (live_nei == 3):
                    board[row][col] = 2
                    
        for r in range(rows):
            for c in range(cols):
                if board[r][c] > 0:
                    board[r][c] =1
                else:
                    board[r][c] = 0                
                    
                    
                    

                    