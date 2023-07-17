class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m= len(board)
        n= len(board[0])
        #      right, left,   up,      down, upleft,  upright, downright, downleft
        dirs= [(0,1), (0,-1), (-1,0), (1,0), (-1, -1), (-1,1), (1,1), (1,-1)]
        for i in range(m):
            for j in range(n):
                cnt= 0
                for x, y in dirs: 
                    if ( i + x < m and i + x >= 0 ) and ( j + y < n and j + y >=0 ) and abs(board[i + x][j + y]) == 1:
                        cnt += 1
                if board[i][j]==1 and (cnt<2 or cnt>3):
                    board[i][j]= -1
                if board[i][j]== 0 and cnt==3:
                    board[i][j]= 2
            
        for i in range(m):
            for j in range(n):
                board[i][j]=1 if (board[i][j]>0) else 0
        return board