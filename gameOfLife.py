# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:

        n = len(board)
        if(n == 0):
            return board

        m = len(board[0])

        for r in range(n):
            for c in range(m):
                alive_neighbors = 0
                for r_offset, c_offset in [(-1, -1), (1, 1), (1, -1), (-1, 1),
                                           (-1, 0), (1, 0), (0, -1), (0, 1)]:

                    new_r = r + r_offset
                    new_c = c + c_offset

                    if (new_r < 0) or (new_r >= n) or (new_c < 0) or (new_c >= m):
                        continue
                    alive_neighbors += (board[new_r][new_c] % 2)

                if (board[r][c] == 0) and (alive_neighbors == 3):
                    # dead cell becomes living cell
                    board[r][c] = 2

                elif (board[r][c] == 1) and (alive_neighbors < 2):
                    # alive cell becomes dead
                    board[r][c] = 3

                elif (board[r][c] == 1) and (alive_neighbors > 3):
                    # alive cell becomes dead
                    board[r][c] = 3


        for r in range(n):
            for c in range(m):
                if board[r][c] == 3:
                    board[r][c] = 0
                elif board[r][c] == 2:
                    board[r][c] = 1
