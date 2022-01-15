#Time Complexity : O(1)
#Space Complexity : O(1)
#LC_289
class Solution:
    def sumNeighbors(self,i,j, m,n):
        sum = 0
        if (i-1) >=0 :
            if (j-1) >=0 : 
                if self.board[i-1][j-1] > 0 : sum += 1
            if self.board[i-1][j] > 0 : sum += 1
            if (j+1) < n: 
                if self.board[i-1][j+1] > 0 : sum += 1              
        if  (j-1) >=0 : 
            if self.board[i][j-1] > 0 : sum += 1
        if  (j+1) < n : 
            if self.board[i][j+1] > 0 : sum += 1                
        if (i+1) < m :
            if (j-1) >=0 : 
                if self.board[i+1][j-1] > 0 : sum += 1
            if self.board[i+1][j] > 0 : sum += 1
            if (j+1) < n: 
                if self.board[i+1][j+1] > 0 : sum += 1                
        return(sum)
            
    def gameOfLife(self, board: List[List[int]]) -> None:
        self.board = board
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                s = self.sumNeighbors(i,j,m,n)
                if board[i][j] == 1:
                    if s < 2 or s > 3: board[i][j] = 2 #Any live cell with fewer than two live neighbors dies#Any live cell with more than three live neighbors dies
                if board[i][j] == 0:
                    if s == 3: board[i][j] = -1#Any dead cell with three live neighbors becomes a live cell
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1: board[i][j] =1
                if board[i][j] == 2: board[i][j] =0