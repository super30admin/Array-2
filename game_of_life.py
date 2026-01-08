"""
time - o(n)
space - o(1)
we follow the rules and change 0 to 1 and 1 to 0, however, this causes information
loss. So we represent 0 -> 1 change as 2 and 1 -> 0 change as 3
"""

from typing import List


class Solution:
    def get_score(self, board, i, j):
        direction = [
            (0, -1),
            (-1, -1),
            (-1, 0),
            (-1, 1),
            (0, 1),
            (1, 1),
            (1, 0),
            (1, -1),
        ]
        score = 0
        for d in direction:
            if 0 <= i + d[0] < len(board) and 0 <= j + d[1] < len(board[0]):
                val = board[i + d[0]][j + d[1]]
                if val < 2:
                    score += val
                elif val == 3:
                    score += 1
        return score

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 0 -> 1 = 2 and 1 -> 0 = 3
        for i in range(len(board)):
            for j in range(len(board[0])):
                score = self.get_score(board, i, j)
                if (score < 2 or score > 3) and board[i][j] == 1:
                    board[i][j] = 3
                elif score == 3 and board[i][j] == 0:
                    board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == 3:
                    board[i][j] = 0
