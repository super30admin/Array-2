
# time O(n*m), space O(1)

class Solution:
    def gameOfLife(self,board: List[List[int]]):

        for r in range(len(board)):
            for c in range(len(board[0])):
                cnt = self.countAlive(board, r,c)
                if board[r][c] == 1 and (cnt < 2 or cnt > 3):
                    board[r][c]=2
                elif board[r][c] == 0 and cnt == 3:
                    board[r][c]=3

        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] == 2:
                    board[r][c]=0
                elif board[r][c] == 3:
                    board[r][c]=1
        return board 


    def countAlive(self,board, r,c):
        dirs = [(0,1),(0,-1),(-1,0),(1,0),(-1,-1),(-1,1),(1,-1),(1,1)]
        cntAlive=0
        for d in dirs:
            nr = r+d[0]
            nc = c+d[1]
            if (nr >= 0 and nc >= 0 and nr < len(board) and nc < len(board[0])):
                if board[nr][nc] == 1 or board[nr][nc]==2:
                    cntAlive+=1
        return cntAlive