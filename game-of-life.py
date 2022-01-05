# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes


from typing import List


class Solution:

    # check the rules of the game

    def rulecheck(self, val, alive, dead):

        if val == 1:
            if alive > 3 or alive < 2:
                return 3
            else:
                return val
        else:
            if alive == 3:
                return 2
            else:
                return val

    def count(self, board, i, j, row, col):

        # Neighbors array to find 8 neighboring cells for a given cell

        l1 = [-1, -1, -1, 0, 0, 1, 1, 1]
        l2 = [-1, 0, 1, -1, 1, -1, 0, 1]

        alive = 0
        dead = 0

        for k in range(8):

            # Check the validity of the neighboring cell and if it was originally a live cell

            if i + l1[k] > -1 and i + l1[k] < row and j + l2[k] > -1 and j + l2[k] < col:

                if board[i + l1[k]][j + l2[k]] == 1 or board[i + l1[k]][j + l2[k]] == 3:
                    alive = alive + 1

                else:
                    dead = dead + 1
        return alive, dead

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        alive = 0
        dead = 0

        row = len(board)
        col = len(board[0])

        for i in range(row):
            for j in range(col):
                alive, dead = self.count(board, i, j, row, col)
                board[i][j] = self.rulecheck(board[i][j], alive, dead)

        for i in range(row):
            for j in range(col):

                if board[i][j] == 3:
                    board[i][j] = 0

                elif board[i][j] == 2:
                    board[i][j] = 1
