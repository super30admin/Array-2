# 289. Game of Life
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m = len(board)
        n = len(board[0])

        directions = [(0,-1), (0,1),(-1,0),(1,0),(-1,-1),(-1,1),(1,-1),(1,1)]

        def helper(board,i,j,directions,m,n):
            count = 0
            for dirs in directions:
                r = dirs[0] + i
                c = dirs[1] + j

                if r >= 0 and c >= 0 and r < m and c < n:
                    if board[r][c] == 1 or board[r][c] == 2:
                        count += 1
            return count

        for i in range(0,m):
            for j in range(0,n):
                count = helper(board,i,j,directions,m,n)

                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        # alive -> dead
                        board[i][j] = 2

                if board[i][j] == 0:
                    if count == 3:
                        # dead -> alive
                        board[i][j] = 3

        for i in range(0,m):
            for j in range(0,n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

        
        