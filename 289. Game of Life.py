#TC O(m*n) SC O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None or len(board) == 0:
            return
        m = len(board) #row
        n = len(board[0]) #col
        for i in range(m):
            for j in range(n):
                liveNeighbors = self.liveNeighborCount(board, i, j)
                if board[i][j] == 1:
                    if liveNeighbors < 2 or liveNeighbors > 3:
                        board[i][j] = 2 #live to dead  1->0 = 2
                elif board[i][j] == 0:
                    if liveNeighbors == 3:
                        board[i][j] = 3 # dead to alive 0->1 = 3  
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        
    def liveNeighborCount(self, board: List[List[int]], row: int, col: int) -> int:
        count = 0
        m = len(board) #row
        n = len(board[0]) #col
        dirs = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]
        #U, D, L, R, UL, UR, LL, LR
        for Dir in dirs:
            nr = row + Dir[0]
            nc = col + Dir[1]
            if nr >= 0 and nr < m and nc >=0 and nc < n and (board[nr][nc] ==1 or board[nr][nc] == 2):
                count = count+1
        print(count)
        return count