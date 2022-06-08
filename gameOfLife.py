class Solution:
    direction = [[0, 1], [0, -1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]

    def gameOfLife(self, board: List[List[int]]) -> None:

        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        # 1--0--3, 0--1--2

        for i in range(m):
            for j in range(n):
                count = self.checkDirection(board, i, j)
                if (board[i][j] == 1 and (count < 2 or count > 3)):
                    board[i][j] = 3
                if (board[i][j] == 0 and count == 3):
                    board[i][j] = 2

        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1

    def checkDirection(self, board, i, j):
        count = 0
        for x in self.direction:
            newRow = i + x[0]
            newCol = j + x[1]
            if (newRow >= 0 and newCol >= 0 and newRow < len(board) and newCol < len(board[0])):
                if (board[newRow][newCol] == 1 or board[newRow][newCol] == 3):
                    count += 1
        return count

