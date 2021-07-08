class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == [] or len(board) == 0:
            return
        
        m = len(board)
        n = len(board[0])
        
        for i in range(0,m):
            for j in range(0,n):
                # count live neighbors
                count = self.countLiveNeighbors(board, i, j, m, n)
                
                if (board[i][j] == 1 and (count<2 or count>3)):
                    board[i][j] = 3
                if (board[i][j] == 0 and count == 3):
                    board[i][j] = 2
        
        for i in range(0,m):
            for j in range(0,n):
                if (board[i][j] == 3):
                    board[i][j] = 0
                elif  (board[i][j] == 2):
                    board[i][j] = 1
    
    def countLiveNeighbors(self, board, i, j, m, n):
        dirs = [[-1,-1],[-1,1],[1,1],[1,-1],[0,1],[1,0],[0,-1],[-1,0]]
        result = 0
        for di in dirs:
            r = i+di[0]
            c = j+di[1]
        
            if (r>=0 and r<m and c >=0 and c <n):
                if (board[r][c] == 1 or board[r][c] == 3):
                    result+=1
            
        return result
        

        
        
