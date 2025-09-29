class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        # Getting the number of rows and columns in the board
        rows, cols = len(board), len(board[0])

        def countLiveNeighbors(r, c):
            # Counting the number of live neighbors for cell (r, c)
            live_neighbors = 0
            for i in range(r - 1, r + 2):
                for j in range(c - 1, c + 2):
                    # Skipping the cell itself and out-of-bound indices
                    if (i == r and j == c) or i < 0 or j < 0 or i >= rows or j >= cols:
                        continue
                    # Checking if the neighbor is currently alive (1 or -1)
                    if abs(board[i][j]) == 1:
                        live_neighbors += 1
            return live_neighbors

        # Iterating through each cell to determine its next state
        for r in range(rows):
            for c in range(cols):
                live_neighbors = countLiveNeighbors(r, c)

                # Marking live cells that should die as -1
                if board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[r][c] = -1  

                # Marking dead cells that should become alive as 2
                if board[r][c] == 0 and live_neighbors == 3:
                    board[r][c] = 2    

        # Updating the board to the next state by converting temporary markers
        for r in range(rows):
            for c in range(cols):
                # Setting cells to alive if their value is positive
                if board[r][c] > 0:
                    board[r][c] = 1
                # Setting cells to dead otherwise
                else:
                    board[r][c] = 0

# Time Complexity (TC): O(m * n), where m and n are the number of rows and columns, respectively.
# Space Complexity (SC): O(1), since the board is being updated in-place without using extra space.