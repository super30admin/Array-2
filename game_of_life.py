# Time complexity - O(mn) (where m,n: rows and column length)
# Space Complexity: O(1) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : State change


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        if board is None or len(board) == 0:
            return
        
        rows, cols = len(board), len(board[0])
        
        for i in range(rows):
            for j in range(cols):
                liveCells = self.countLives(board, i, j,rows,cols)
                
                if board[i][j] == 1 and (liveCells < 2 or liveCells > 3):
                    board[i][j] = 3
                    
                elif board[i][j] == 0 and liveCells == 3:
                    board[i][j] = 2
        
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 3:
                    board[i][j] = 0
                    
                elif board[i][j] == 2:
                    board[i][j] = 1
                    
    def countLives(self,board, i, j,rows,cols):
            count = 0
            direction = [(0,1), (1,0), (1,1), (0,-1), (-1,0), (-1,-1), (1,-1), (-1,1)]
            for dx, dy in direction:
                new_x = i + dx
                new_y = j + dy
                if 0 <= new_x < rows and 0 <= new_y < cols and (board[new_x][new_y] == 1 or board[new_x][new_y] == 3):
                    count += 1
            return count
        