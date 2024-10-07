class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        output = []
        
        m = len(board)
        n = len(board[0])
        
        def neighbours(i,j):
                direction = [(0,-1), (0,1),(1,0),(-1,0),(1,-1),(-1,1),(1,1),(-1,-1)]
                nei = 0
                for x,y  in direction:
                        x_cor = i + x
                        y_cor = j + y
                        if 0<= x_cor < m and 0<= y_cor < n:
                            if board[x_cor][y_cor] == 1 or board[x_cor][y_cor] == 3:
                                nei +=1
                return nei
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 0:
                    if neighbours(i,j) == 3:
                        board[i][j] = 2
                    
                elif board[i][j] == 1:
                    if neighbours(i,j) not in [2,3]:
                        board[i][j] = 3
            
        
        for i in range(m):
            for j in range(n):
                if board[i][j]  == 2:
                    board[i][j] = 1
                elif board[i][j]  == 3:
                    board[i][j] = 0
        
        
        