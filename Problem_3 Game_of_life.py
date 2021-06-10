# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #  if 0->1 change it to 2 (alive)
        #  if 1->0 change it to 3 (Dead)

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count = self.countLives(board, i, j, m, n)
                # Rule 1 and 3
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3  # Cell Alive to dead

                if board[i][j] == 0 and count == 3:
                    board[i][j] = 2  # Cell dead to alive

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == 3:
                    board[i][j] = 0
        return board

    def countLives(self, board, i, j, m, n):
        result = 0
        # {right, left, bottom, up, bottom-right, bottom-left, upper-right, upper-left }

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [1, 1], [1, -1], [-1, 1], [-1, -1]]

        for dir in dirs:
            r = i + dir[0]  # Row index of the neighbour
            c = j + dir[1]  # Column index of the neighbour

            if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] == 1 or board[r][c] == 3):
                result += 1

        return result











