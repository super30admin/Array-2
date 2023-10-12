#LC: 289, yes
#problems: NA
#TC: O(m*n) , n rows, m cols
#SC: O(1), no aux space used
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n = len(board) #rows
        m = len(board[0]) #cols
        # 1--> 0, 2, 
        # 0-->1 , 3
        
        def countAlive(board, i, j):
            neighbors = 0
            for dire in dirs:
                nr = i + dire[0]
                nc = j + dire[1]
                 
                if (nr >= 0 and nr < n) and (nc >= 0 and nc < m) and (board[nr][nc] == 1 or board[nr][nc] == 2):                    
                    neighbors += 1
                
            return neighbors
        
        dirs = [(-1,-1), (0,-1), (1, -1), (1,0), (1,1), (0,1), (-1,1), (-1,0)]
        for i in range(n):
            for j in range(m):
                count = countAlive(board, i, j)
                if board[i][j] == 0 and count == 3:
                        board[i][j] = 3
                if board[i][j] == 1 and (count < 2 or count > 3):
                        board[i][j] = 2
                        
        for i in range(n):
            for j in range(m):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
                    
                
        
                    
                    