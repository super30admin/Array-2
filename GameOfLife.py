# TC = O(mn)
# SC =o(1)


class Solution:
    def countLives(self, board, r, c):
        directions = [
            (-1, 0),
            (1, 0),
            (0, -1),
            (0, 1),
            (-1, -1),
            (-1, 1),
            (1, -1),
            (1, 1),
        ]
        count = 0
        for direction in directions:
            nr = r + direction[0]
            nc = c + direction[1]
            print(nr, nc)
            if (nc >= 0 and nc < len(board[0])) and (nr >= 0 and nr < len(board)):
                if board[nr][nc] == 1 or board[nr][nc] == -1:
                    count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count = self.countLives(board, i, j)

                if board[i][j] == 1 and count < 2:
                    board[i][j] = -1
                elif board[i][j] == 1 and count > 3:
                    board[i][j] = -1
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = -2

        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                if board[i][j] == -2:
                    board[i][j] = 1
