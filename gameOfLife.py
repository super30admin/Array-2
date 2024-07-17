class Solution:
    # Space complexity: O(8*M*N)= O(M*N)
    # Space complexity : O(1)
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # Get the dimensions of the board
        m = len(board)
        n = len(board[0])

        # Traverse each cell in the board
        for i in range(m):
            for j in range(n):
                # Count the number of live neighbors for the current cell
                livenbr = self.livenbrs(board, i, j)

                # Rules for live cells (board[i][j] == 1)
                if board[i][j] == 1:
                    # Any live cell with fewer than two live neighbors dies
                    # Any live cell with more than three live neighbors dies
                    if livenbr < 2 or livenbr > 3:
                        board[i][j] = 2 # Mark as 2 to indicate live to dead transition (1 -> 0)

                # Rules for dead cells (board[i][j] == 0)
                elif board[i][j] == 0:
                    # Any dead cell with exactly three live neighbors becomes a live cell
                    if livenbr == 3:
                        board[i][j] = 3 # Mark as 3 to indicate dead to live transition (0 -> 1)

        # Traverse the board again to finalize the state changes
        for i in range(m):
            for j in range(n):
                # Change marked cells to their new state
                if board[i][j] == 2:
                    board[i][j] = 0 # Live to dead
                if board[i][j] == 3:
                    board[i][j] = 1 # Dead to live

    def livenbrs(self, board: List[List[int]], row: int, col: int) -> int:
        # Get the dimensions of the board
        m = len(board)
        n = len(board[0])

        # Initialize count of live neighbors
        count = 0

        # Define the 8 possible directions to check neighbors
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]

        # Check all 8 neighbors
        for dir in dirs:
            nr = row + dir[0] # New row index
            nc = col + dir[1] # New column index

            # If the neighbor is within bounds and is a live cell (either 1 or 2)
            if nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1 # Increment live neighbors count

        return count # Return the count of live neighbors
