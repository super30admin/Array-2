#TC:O(M*N), where M,N are row and column of matrix
#SC:O(1)
class Solution:
    def valid(self,board, x, y):
        if (x>=0 and x<len(board)) and (y>=0 and y<len(board[0])):
            return True
        else:
            return False
               
    def noOfAliveCell(self, board,r,c):
        mapping = [[1,0],[-1,0],[0,1], [0,-1],[1,1],[-1,-1],[1,-1],[-1,1]]
        count = 0
        for i in range(len(mapping)):
            x = r + mapping[i][0]
            y = c + mapping[i][1]
            if self.valid(board,x,y):
                if board[x][y] == -2 or board[x][y] == 1:
                    count += 1
        return count
            
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                live = self.noOfAliveCell(board,i,j)
                if board[i][j] == 1:
                    if live < 2 or live > 3:
                        board[i][j] = -2
                if board[i][j] == 0:
                    if live == 3:
                        board[i][j] = -1
                        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == -2:
                    board[i][j] = 0
                if board[i][j] == -1:
                    board[i][j] = 1
        