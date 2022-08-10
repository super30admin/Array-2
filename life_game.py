# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List


class Solution:
    m = 0
    n = 0
    _board = [[]]

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.m = len(board)
        self.n = len(board[0])
        self._board = board

        for i in range(self.m):
            for j in range(self.n):
                neighbours = self.count_neighbours(i, j)
                if self._board[i][j] == 1 and (neighbours < 2 or neighbours > 3):
                    self._board[i][j] = 2
                elif self._board[i][j] == 0 and neighbours == 3:
                    self._board[i][j] = 3

        for i in range(self.m):
            for j in range(self.n):
                if self._board[i][j] == 2:
                    self._board[i][j] = 0
                elif self._board[i][j] == 3:
                    self._board[i][j] = 1

        print(board)

    def count_neighbours(self, r: int, c: int) -> int:
        neighbours = [[0, 1], [1, 0], [1, 1], [-1, 0], [0, -1], [1, -1], [-1, 1], [-1, -1]]
        count = 0
        for neighbour in neighbours:
            row = r + neighbour[0]
            col = c + neighbour[1]
            if 0 <= row < self.m and 0 <= col < self.n and (self._board[row][col] == 1 or self._board[row][col] == 2):
                count += 1
        return count


if __name__ == '__main__':
    _board_ = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    Solution().gameOfLife(_board_)
