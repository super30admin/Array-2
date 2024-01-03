#Time Complexity: O(m * n)
#Space Complexity: O(1)


class Solution:
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0:
            return

        rows, cols = len(board), len(board[0])

        def count_live_neighbors(board, i, j):
            count = 0
            directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

            for dir_i, dir_j in directions:
                ni, nj = i + dir_i, j + dir_j
                if 0 <= ni < rows and 0 <= nj < cols and (board[ni][nj] == 1 or board[ni][nj] == 3):
                    count += 1

            return count

        for i in range(rows):
            for j in range(cols):
                count_live = count_live_neighbors(board, i, j)

                # If the cell was dead
                if board[i][j] == 0:
                    # When it has exactly 3 live neighbors
                    if count_live == 3:
                        board[i][j] = 2
                # If the cell was alive
                else:
                    # Fewer than 2 live neighbors
                    if count_live < 2:
                        board[i][j] = 3
                    # More than 3 live neighbors
                    elif count_live > 3:
                        board[i][j] = 3

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
