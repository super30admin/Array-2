# time complexity: O(mn)
 # space complexity: O(1)
def gameOfLife(self, board: List[List[int]]) -> None:
       
        # 0 -->1 3
        # 1 -->0 2
        m = len(board)
        n = len(board[0])
        self.dirs = [[0,1],[1,0],[-1,0],[0,-1],[-1,-1],[-1,1],[1,-1],[1,1]]
        # iterate over the board
        for i in range(m):
            for j in range(n):
                # see for alive cells
                count = self.countAlive(board,i,j)
                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = 2 
                else:
                    if count == 3:
                        board[i][j] = 3
                    
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
 

def countAlive(self,board,i,j):
    count = 0
    for d in self.dirs:
        nr = i + d[0]
        nc = j + d[1]
        # bounds check 
        if (nr >= 0 and nr < len(board)) and (nc >= 0 and nc <len(board[0])) and (board[nr][nc]==1 or board[nr][nc]==2):
                count +=1
    return count






