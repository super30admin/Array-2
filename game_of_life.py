class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        dirs = [(1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1)]
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                live = 0
                for x, y in dirs:
                    if (
                        (i + x < len(board) and i + x >= 0)
                        and (j + y < len(board[0]) and j + y >= 0)
                        and abs(board[i + x][j + y]) == 1
                    ):
                        live += 1
                if board[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] = -1
                if board[i][j] == 0 and (live == 3):
                    board[i][j] = 2
        print(board)
        for i in range(m):
            for j in range(n):
                board[i][j] = 1 if (board[i][j] > 0) else 0
        return board
