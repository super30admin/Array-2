"""
Problem: Game of Life
Solution: https://leetcode.com/problems/game-of-life/
Time Complexity: O(M*N), where M is the number of rows and N is the number of columns of the Board.
Space Complexity: O(1), used in place matrix
"""


class Solution(object):
    def gameOfLife(self, board):
        # Base cases
        if board is None or len(board) is 0:
            return

        rows = len(board)
        cols = len(board[0])

        for i in range(rows):
            for j in range(cols):
                lives = self.countLives(i, j, board)
                # Rule 1 and Rule 3:
                if board[i][j] == 1 and (lives < 2 or lives > 3):
                    board[i][j] = 2
                # Rule 4
                if board[i][j] == 0 and lives == 3:
                    board[i][j] = 3

        # for the final output, convert 2 -> 0, 3 -> 1
        for i in range(rows):
            for j in range(cols):
                board[i][j] = board[i][j] % 2
        return board

    # Helper function
    def countLives(self, row, col, board):
        count = 0
        rows = len(board)
        cols = len(board[0])
        directions = [[1, -1], [1, 0], [-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, 1]]
        for dire in directions:
            new_row = dire[0] + row
            new_col = dire[1] + col
            if new_row >= 0 and new_row < rows and new_col >= 0 and new_col < cols and (board[new_row][new_col] == 1 or
                    board[new_row][new_col] == 2):
                count += 1
        return count


obj = Solution()
nums = [
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
print(obj.gameOfLife(nums))
