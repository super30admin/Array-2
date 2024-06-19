# Time O(M*N)
# Space O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                nbs = self.get_nb(board, i, j)
                if board[i][j] == 1 and (nbs < 2 or nbs > 3) :
                    board[i][j] = -1 # live to dead
                elif board[i][j] == 0 and nbs == 3:
                    board[i][j] = 2 # dead to alive
        for k in range(m):
            for l in range(n):
                if board[k][l] == -1:
                    board[k][l] = 0
                elif board[k][l] == 2:
                    board[k][l] = 1
        return board
    def get_nb(self, board, row, col):
        m = len(board)
        n = len(board[0])
        count = 0
        dirr = [[0,1],[-1,-1], [-1,0], [-1,1], [0,-1], [1,-1], [1,0],[1,1]]
        for dir in dirr:
            
            nr = row + dir[0]
            nc = col + dir[1]
            if nr >= 0 and nr < m and nc >= 0 and nc < n and abs(board[nr][nc]) == 1:
                count +=1
        return count
