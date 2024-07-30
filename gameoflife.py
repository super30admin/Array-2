from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        rows = len(board)
        columns = len(board[0])

        # Create a copy of the original board to keep track of the original state
        copy_board = [row[:] for row in board]

        # List of 8 possible directions (top, bottom, left, right and the 4 diagonals)
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]

        for i in range(rows):
            for j in range(columns):
                live_neighbors = 0

                # Check all 8 neighbors
                for direction in directions:
                    new_row, new_col = i + direction[0], j + direction[1]
                    if 0 <= new_row < rows and 0 <= new_col < columns and copy_board[new_row][new_col] == 1:
                        live_neighbors += 1

                # Apply the rules of the Game of Life
                if copy_board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = 0  # Live cell dies
                elif copy_board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 1  # Dead cell becomes a live cell

# Example usage:
# solution = Solution()
# board = [
#     [0, 1, 0],
#     [0, 0, 1],
#     [1, 1, 1],
#     [0, 0, 0]
# ]
# solution.gameOfLife(board)
# print(board)
