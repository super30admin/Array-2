"""
Time Complexity: O(rows*columns)
Space Complexity: O(1)
"""


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1 --> 0 = 3
        # 0 --> 1 = 2

        row = len(board)
        column = len(board[0])

        for i in range(row):
            for j in range(column):
                # rules
                lives = self.countLives(board, i, j, row, column)
                # rule 2 --> cell dies
                if board[i][j] == 1 and (lives < 2 or lives > 3):
                    board[i][j] = 3

                # rule 4 --> cell lives
                if board[i][j] == 0 and (lives == 3):
                    board[i][j] = 2

        for i in range(row):
            for j in range(column):
                if board[i][j] == 3:
                    board[i][j] = 0

                if board[i][j] == 2:
                    board[i][j] = 1

        return board

    def countLives(self, board, i, j, row, column):
        # up, down, left, right, diagonal left up, diagonal right up, diagonal left down,
        # diagonal right down
        result = 0
        dirArray = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]

        for direction in dirArray:
            r = direction[0] + i
            c = direction[1] + j

            # check boundary and live cells
            if r >= 0 and r < row and c >= 0 and c < column and (board[r][c] == 1 or board[r][c] == 3):
                result += 1

        return result

