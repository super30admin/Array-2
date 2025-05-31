# Time Complexity: O(m*n)
# Space Complexity: O(1)
class Solution:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = self.countAlives(board,i,j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 5
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 4
        for i in range(m):
            for j in range(n):
                if board[i][j] == 5:
                    board[i][j] = 0
                if board[i][j] == 4:
                    board[i][j] = 1
    
    def countAlives(self, board, r, c):
                # r.   l.     up,    down. upr.   upl.    dr.    dl      
        dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,1],[-1,-1],[1,1],[1,-1]]
        result = 0
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            if (nr >= 0 and nc >= 0 and nr < len(board) and nc < len(board[0]) and (board[nr][nc]==1 or board[nr][nc]==5)):
                result+=1

        return result
