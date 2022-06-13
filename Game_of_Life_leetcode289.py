class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n = len(board)
        m = len(board[0])
        for row in range(n):
            for col in range(m):
                liveNeighbor = 0

                # define boundaries
                top = max(0, row - 1)
                bottom = min(n - 1, row + 1)
                left = max(0, col - 1)
                right = min(m - 1, col + 1)

                for i in range(top, bottom + 1):
                    for j in range(left, right + 1):
                        if not (i == row and j == col) and abs(board[i][j]) == 1:
                            liveNeighbor += 1

                if board[row][col] == 1:
                    if liveNeighbor < 2 or liveNeighbor > 3:
                        board[row][col] = -1
                else:
                    if liveNeighbor == 3:
                        board[row][col] = 2

        for row in range(n):
            for col in range(m):
                if board[row][col] == -1:
                    board[row][col] = 0

                elif board[row][col] == 2:
                    board[row][col] = 1

