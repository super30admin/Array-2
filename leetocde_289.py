class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m = len(board)
        n = len(board[0])

        directions = [(-1,-1),(-1,0),(-1,1),
                      (0,-1),        (0,1),
                      (1,-1),(1,0),(1,1)]

        for i in range(m):
            for j in range(n):
                live = 0
                for dx, dy in directions:
                    x = i + dx
                    y = j + dy
                    if 0 <= x < m and 0 <= y < n and abs(board[x][y]) == 1:
                        live += 1

                if board[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] = -1   # live → dead
                if board[i][j] == 0 and live == 3:
                    board[i][j] = 2    # dead → live

        for i in range(m):
            for j in range(n):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0