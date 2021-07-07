from typing import List


class Solution:

    def __init__(self):
        self.rows = -1
        self.cols = -1

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        """
            // Time Complexity : O(mn)
            // Space Complexity : O(1) 
            // Did this code successfully run on Leetcode : Yes
            // Three line explanation of solution in plain english
                - For each element in the matrix, count the number of 
                  live neighbours
                - For each case, if we need to flip alive to dead or 
                  dead to alive temporarily change it to a different value  
                  just to take into account that the state of this element 
                  has been changed. 
                - Traverse the matrix and for each temp change value, change
                  to the corresponding correct state.
        """
        if not board:
            return

        self.rows = len(board)
        self.cols = len(board[0])
        # Live 1 -> -1 (dead)
        # Dead 0 -> 2  (live)
        for row in range(self.rows):
            for col in range(self.cols):
                count = self.live_count(board, row, col)
                # if alive and neighbour alive < 2 or > 3
                # must die
                if board[row][col] == 1 and (count < 2 or count > 3):
                    board[row][col] = -1
                # if dead and neigbour alive is 3
                # now alive
                elif board[row][col] == 0 and count == 3:
                    board[row][col] = 2

        for row in range(self.rows):
            for col in range(self.cols):
                if board[row][col] == -1:
                    board[row][col] = 0
                elif board[row][col] == 2:
                    board[row][col] = 1

    def live_count(self, board: List[List[int]], row: int, col: int):
        # int array direction
        #             up       down    left    right
        neighbors = [(-1, 0), (1, 0), (0, -1), (0, 1),
                     (-1, -1), (-1, 1), (1, -1), (1, 1)]
        #            up_left  up_right down_left down_right
        count = 0
        for n_r, n_c in neighbors:
            n_r = row + n_r
            n_c = col + n_c
            if n_r >= 0 and n_r < self.rows and n_c >= 0 and n_c < self.cols:
                if board[n_r][n_c] == 1 or board[n_r][n_c] == -1:
                    count += 1
        return count


if __name__ == '__main__':
    h = Solution()
    board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    h.gameOfLife(board)
    print(board)
