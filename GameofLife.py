# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        neighbors = [(1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1),
                     (0, 1), (1, 1)]

        rows = len(board)
        cols = len(board[0])

        # Create a copy of the original board
        copy_board = [[board[row][col] for col in range(cols)]
                      for row in range(rows)]

        # Iterate through board cell by cell.
        for row in range(rows):
            for col in range(cols):

                # For each cell count the number of live neighbors.
                live_neighbors = 0
                for neighbor in neighbors:

                    r = (row + neighbor[0])
                    c = (col + neighbor[1])

                    # Check the validity of the neighboring cell and if it was originally a live cell.
                    # The evaluation is done against the copy, since that is never updated.
                    if (r < rows and r >= 0) and (c < cols and c >= 0) and (
                            copy_board[r][c] == 1):
                        live_neighbors += 1

                if copy_board[row][col] == 1 and (live_neighbors < 2
                                                  or live_neighbors > 3):
                    board[row][col] = 0

                if copy_board[row][col] == 0 and live_neighbors == 3:
                    board[row][col] = 1
