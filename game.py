class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # TC O(mn)
        # SC O(1)
        if board is None or len(board) == 0:
            return
        m = len(board)
        n = len(board[0])
        
        def countlives(board, i, j , m , n):
            result = 0
            r = 0
            c = 0
            dirs = [[0,1],[-1,0],[1,0],[0,-1],[1,1],[-1,-1],[1,-1],[-1,1]] 
            
            #dies = 2
            # live 3
            for d in dirs:
                r = i + d[0]
                c = j + d[1]
                
                if r>=0 and r<m and c>=0 and c < n and (board[r][c] == 1 or board[r][c] == 2):
                        result += 1
            return result
            
        for i in range(m):
            for j in range(n):
                count = countlives(board, i, j , m , n)
               
                #Rule 1, 3
                if (board[i][j] ==1) and (count < 2 or count > 3):
                    board[i][j] = 2
                    
                #Rule 4
                if board[i][j] ==0 and count == 3:
                    board[i][j] = 3
        print(board)           
        for i in range(m):
            for j in range(n):
                count = countlives(board, i, j , m , n)
                
                #Rule 1
                if board[i][j] ==2:
                    board[i][j] = 0
                    
                #Rule 4
                if board[i][j] == 3:
                    board[i][j] = 1
        print(board)
        
