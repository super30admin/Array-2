class Solution:

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                neighbours = self.countlives(board, m, n, i, j)

                if board[i][j] == 1 and (neighbours < 2 or neighbours > 3):
                    board[i][j] = 3

                elif board[i][j] == 0 and neighbours == 3:
                    board[i][j] = 2

        for i in range(m):
            for j in range(n):

                if board[i][j] == 2:
                    board[i][j] = 1

                elif board[i][j] == 3:
                    board[i][j] = 0

        return board

    def countlives(self, board, m, n, i, j):
        count = 0
        directions = [(1, 1), (1, -1), (-1, 1), (-1, -1), (1, 0), (0, 1), (0, -1), (-1, 0)]

        for direction in directions:

            r = direction[0] + i
            c = direction[1] + j
            if r >= 0 and c >= 0 and r < m and c < n and (board[r][c] == 1 or board[r][c] == 3):
                count += 1
        return count