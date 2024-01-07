# Problem: Game of Life
# time: O(m * n)
#  space: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
    
        m, n = len(board), len(board[0])

        def count_live_neighbors(i, j):
            count = 0
            directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]

            for dx, dy in directions:
                ni, nj = i + dx, j + dy
                if 0 <= ni < m and 0 <= nj < n and (board[ni][nj] == 1 or board[ni][nj] == -1):
                    count += 1

            return count

        for i in range(m):
            for j in range(n):
                live_neighbors = count_live_neighbors(i, j)

                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = -1  # Mark as dying
                elif board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 2   # Mark as becoming alive

        # Update the board based on the marked cells
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1

        return board