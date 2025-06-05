"""
TC -> O(ROWS*COLS)
SC ->O(1) In place modification is being done

"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS = len(board)
        COLS = len(board[0])

        def count_neighbors(r, c, board):
            neighbors = [
                [-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]
            ]
            cnt = 0
            for del_row, del_col in neighbors:
                n_row, n_col = r + del_row, c + del_col

                if 0 <= n_row < ROWS and 0 <= n_col < COLS and (board[n_row][n_col] == 1 or board[n_row][n_col] == 5):
                    cnt += 1
            return cnt

        for i in range(ROWS):
            for j in range(COLS):
                live = count_neighbors(i, j, board)
                if (board[i][j] == 1 and live < 2) or (board[i][j] == 1 and live > 3):
                    board[i][j] = 5  # "Live -> Dead"
                elif board[i][j] == 0 and live == 3:
                    board[i][j] = 4  # "Dead -> Live "

        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == 4:
                    board[i][j] = 1
                elif board[i][j] == 5:
                    board[i][j] = 0
