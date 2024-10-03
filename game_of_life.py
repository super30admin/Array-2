class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        m = len(board)  # Number of rows
        n = len(board[0])  # Number of columns
        # Directions for left, right, up, down, and diagonals
        dirs = [[0, -1], [0, 1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]

        # Iterate through each cell to apply the rules of the game
        for i in range(m):
            for j in range(n):
                count = self.countAlive(dirs, board, i, j)  # Count alive neighbors
                if board[i][j] == 1:  # If the cell is alive
                    if count < 2 or count > 3:
                        board[i][j] = 2  # Mark as dead (1 -> 0)
                elif board[i][j] == 0:  # If the cell is dead
                    if count == 3:
                        board[i][j] = 3  # Mark as alive (0 -> 1)

        # Update the board to the new state
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0  # Update marked dead cells
                elif board[i][j] == 3:
                    board[i][j] = 1  # Update marked alive cells

    def countAlive(self, dirs, board, i, j):
        count = 0
        m = len(board)  # Number of rows
        n = len(board[0])  # Number of columns
        # Check all eight directions for alive neighbors
        for dir in dirs:
            r = dir[0] + i
            c = dir[1] + j
            if r >= 0 and c >= 0 and r < m and c < n:
                if board[r][c] == 1 or board[r][c] == 2:
                    count += 1  # Increment count for alive neighbors
        return count


# Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
# Space Complexity: O(1)
