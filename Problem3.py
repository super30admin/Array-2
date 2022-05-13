#Time Complexity: O(mn)
#Space Complexity: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        dirs = [[0,1],[1,0],[-1,0],[0,-1],[-1,-1],[1,-1],[-1,1],[1,1]]
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                count = self.countAlive(board,i,j,dirs,m,n)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 2
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
    def countAlive(self,board,i,j,dirs,m,n):
        count = 0
        for lst in dirs:
            r = i+lst[0]
            c = j+lst[1]
            if r >= 0 and r < m and c >=0 and c < n and (board[r][c] == 1 or board[r][c] == 3):
                count += 1
        return count