class Solution(object):
    def gameOfLife(self, board):
        """
        Modifies the board in-place based on the game of life rules.
        Time complexity: O(m*n), where m is the number of rows and n is the number of columns in the board.
        Space complexity: O(1), since the modifications are done in-place without using any extra space.
        :type board: List[List[int]]
        :rtype: None
        """
        rows = len(board)
        cols = len(board[0])
        # Directions: right, left, up, down, upleft, upright, downleft, downright
        directions = [(0, 1), (0, -1), (-1, 0), (1, 0),
                      (-1, -1), (-1, 1), (1, -1), (1, 1)]
        # i,j           i,j+1   i,j-1     i-1,j   i+1,j   i-1,j-1   i-1,j+1  i+1,j-1  i+1,j+1

        def countAlive(board, i, j, rows, cols):
            count = 0  # Initialize the count of live neighbors to 0

            # Iterate over the eight possible directions around the cell
            for direction in directions:
                nr = i + direction[0]  # neighbor row index
                nc = j + direction[1]  # neighbor column index

                # Check if the new coordinates are within the valid range of the board
                if 0 <= nr < rows and 0 <= nc < cols:
                    # Check if the cell at (nr, nc) is live (1) or transitioned from live to dead (2)
                    if board[nr][nc] == 1 or board[nr][nc] == 2:
                        count += 1  # Increment the count of live neighbors

            return count  # Return the final count of live neighbors

        # Iterate over each cell in the board
        for i in range(rows):
            for j in range(cols):
                count = countAlive(board, i, j, rows, cols)
                if board[i][j] == 1:
                    # Rule 1 & 3: Any live cell with fewer than two or more than three live neighbors dies
                    if count < 2 or count > 3:
                        board[i][j] = 2  # Mark the cell from live to dead
                else:
                    # Rule 4: Any dead cell with exactly three live neighbors becomes a live cell
                    if count == 3:
                        board[i][j] = 3  # Mark the cell from dead to live

        # Update the original board values based on the marked cells
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 0  # 2--> 0, live to dead
                if board[i][j] == 3:
                    board[i][j] = 1  # 3 --> 1, dead to live
