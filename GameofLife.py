class Solution:
    """
    Time complexity - O(n). n - size of nums
    Space complexity - O(1)
    """
    # method to count the no of living neighbours.
    def getCount(self, i, j, board):
        n = len(board)
        m = len(board[0])
        coords = [[-1,-1], [-1, 0], [-1,1], [0,-1]
                  ,[0, 1], [1,-1], [1,0], [1,1]]
        count = 0
        for coord in coords:
            x = i + coord[0]
            y = j + coord[1]
            if x < n and x >= 0 and y < m and y >= 0:
                if board[x][y] == 1 or board[x][y] == -1:
                    count += 1
        return count

    def gameOfLife(self, board: list[list[int]]) -> None:
        n = len(board)
        m = len(board[0])
        # -1 represents dead cell
        # 2 represents new cell
        
        for i in range(0, n):
            for j in range(0, m):
                neigh = self.getCount(i, j, board)
                if board[i][j] == 1 and (neigh < 2 or neigh > 3):
                    board[i][j] = -1
                elif board[i][j] == 0 and neigh == 3:
                    board[i][j] = 2
                
        # transform the board to original notion.           
        for i in range(0, n):
            for j in range(0, m):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif  board[i][j] == 2:
                    board[i][j] = 1
    
    
                
                
        
                    
        