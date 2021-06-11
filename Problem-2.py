
"""
Approach:

1) iterate through each element and apply the given conditions
2) notice that your state is not maintained if you change the state of the cells
    a) In order to work around this, you can use encoded values
    b) if 0 changed to 1 --> encode cell value as 2
    c) if 1 changed to 0 --> encode cell value as 3
3) after traversing through all cells, you need to decode your cells

"""

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                if (board[i][j] == 1):
                    if self.logic(board, i, j) < 2:
                        board[i][j] = 3
                    elif self.logic(board, i, j) > 3:
                        board[i][j] = 3
                elif (board[i][j] == 0):
                    if self.logic(board, i, j) == 3:
                        board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                if (board[i][j] == 2):
                    board[i][j] = 1
                elif (board[i][j] == 3):
                    board[i][j] = 0

    def logic(self, board, i, j):
        dirs = [[i, j+ 1], [i, j - 1], [i - 1, j], [i + 1, j], [i + 1, j + 1], [i - 1, j + 1], [i + 1, j - 1],
                [i - 1, j - 1]]
        count = 0

        for x, y in dirs:
            if 0 <= x < len(board) and 0 <= y < len(board[0]) and (board[x][y] == 1 or board[x][y] == 3):
                count += 1
        return count

"""
TC: O(n)
SC: O(1)
"""