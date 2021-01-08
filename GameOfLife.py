'''
    Time Complexity:
        O(mn)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        State Change approach.
'''
LIVE = 1
DEAD = 0
WAS_DEAD = WILL_LIVE = float('inf')
WAS_LIVE = WILL_DIE = -float('inf')
DIRECTIONS = (
    (-1, 0), (-1, 1), (0, 1), (1, 1),
    (1, 0), (1, -1), (0, -1), (-1, -1)
)

class Solution:
    def __init__(self):
        self.board = []

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.board = board
        self.change_state()
        self.revert()

    def change_state(self):
        for i, row in enumerate(self.board):
            for j, cell in enumerate(row):
                live_neighbors = self.count_live_neighbors(i, j)

                if cell == LIVE:
                    if live_neighbors < 2 or live_neighbors > 3:        # rule 1 and 3
                        self.board[i][j] = WILL_DIE
                elif cell == DEAD:
                    if live_neighbors == 3:                             # rule 4
                        self.board[i][j] = WILL_LIVE

    def revert(self):
        for i, row in enumerate(self.board):
            for j, cell in enumerate(row):
                if cell == WILL_LIVE:
                    self.board[i][j] = LIVE
                elif cell == WILL_DIE:
                    self.board[i][j] = DEAD

    def count_live_neighbors(self, i, j):
        count = 0
        for row, col in DIRECTIONS:
            r = i + row
            c = j + col

            if r < 0 or r >= len(self.board):
                continue

            if c < 0 or c >= len(self.board[r]):
                continue

            cell = self.board[r][c]
            if cell == LIVE or cell == WAS_LIVE:                        # WAS_LIVE means WILL_DIE
                count += 1

        return count
