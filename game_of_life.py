#time_complexity = O(M*N)
#space_complexity = O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        #1->0 then 2
        #0->1 then 3
        for i in range(m):
            for j in range(n):
                liveNeigh = self.liveNeightborCount(board,i,j)
                if board[i][j] == 1:
                    if liveNeigh < 2 or liveNeigh > 3:
                        board[i][j] = 2
                else:
                    if liveNeigh ==3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] =0
                elif board[i][j] == 3:
                    board[i][j] = 1
    def liveNeightborCount(self, board: List[List[int]], r:int, c:int) ->int:
        count =0
        m = len(board)
        n = len(board[0])
        dirs = [[-1,0],[1,0],[0,1],[0,-1],[-1,-1],[-1,1],[1,-1],[1,1]]
        for Dir in dirs:
            nr = r + Dir[0]
            nc = c + Dir[1]
            if nr >=0 and nc>=0 and nr < m and nc< n and (board[nr][nc] ==1 or board[nr][nc] ==2):
                count = count + 1
        return count

        