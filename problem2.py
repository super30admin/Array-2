#Time Complexity : O(m*n) ... where m is the number of rows and n is the number of columns
#Space Complexity : O(1) ...as this would be a constant value for storing the directions
#Any problem you faced while coding this : faced issues while forming the conditional checks for neighbors

#Used a predefined set of direction values for checking the neighbors in order to decide on the aliveness. Had to also use the logic of using a set of values -  2 for alive -> dead and 3 for alive -> alive.

class Solution:
    def countAlive(self, board, i, j, m, n, dirs):
        count = 0
        for d in dirs:
            row = i + d[0]
            col = j + d[1]
            if (0 <= row < m) and (0 <= col < n):
                if board[row][col] == 1 or board[row][col] == 2:
                    count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        m = len(board)
        n = len(board[0])

        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0), (-1, -1), (-1, 1), (1, -1), (1, 1)]

        for row in range(m):
            for col in range(n):
                alive = self.countAlive(board, row, col, m, n, dirs)
                if board[row][col] == 1:
                    if alive < 2 or alive > 3:
                        board[row][col] = 2
                elif board[row][col] == 0:
                    if alive == 3:
                        board[row][col] = 3

        for row in range(m):
            for col in range(n):
                if board[row][col] == 2:
                    board[row][col] = 0
                elif board[row][col] == 3:
                    board[row][col] = 1
