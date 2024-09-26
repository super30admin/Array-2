Time Complexity: O(m*n) where m is no. of rows and n is no. of column
Space Complexity: O(1)
class Solution:
    def findNe(self,board,i,j):
        m = len(board)
        n = len(board[0])
        c = 0
        dirs = [[0,1],[1,0],[-1,0],[0,-1],[-1,-1],[1,1],[-1,1],[1,-1]]
        for x,y in dirs:
            x += i
            y += j
            if x >=0 and y >=0 and x<m and y < n and (board[x][y] == 1 or board[x][y] == -2):
                c += 1
        return c
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return board
        for i in range(len(board)):
            for j in range(len(board[0])):
                ne = self.findNe(board,i,j)
                if board[i][j] == 1 and (ne<2 or ne >3):
                    board[i][j] = -2
                elif board[i][j] == 0 and ne ==3:
                    board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == -2:
                    board[i][j] = 0
        
