# Time Complecity: O(m*n)
# Space Complexity: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        # Possible offsets to find the 8 neighboring cells of a given cell
        neighbors = [[-1, -1], [-1, 0], [-1, 1],[0, -1],[0, 1],[1, -1],[1, 0], [1, 1]]
        rows = len(board)
        cols = len(board[0])

        def getCount(board, i, j):
            # Cells marked as 1 (alive) or 3 (alive → dead transition) are considered alive for this calculation.
            count = 0
            for dr, dc in neighbors:
                r, c = i + dr, j + dc
                if 0 <= r < rows and 0 <= c < cols:
                    if board[r][c] == 1 or board[r][c] == 3:
                        count += 1
            return count

        # First pass: mark cells with temporary states
        for i in range(rows):
            for j in range(cols):
                count = getCount(board, i, j)
                
                # Rule 1: Dead cell with exactly 3 neighbors becomes alive
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 2  # dead → alive
                
                # Rule 2 & 3: Live cell with too few (<2) or too many (>3) neighbors dies
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3  # alive → dead

        # Second pass: finalize the board by converting temp states
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 1  # now alive
                elif board[i][j] == 3:
                    board[i][j] = 0  # now dead
        
        return board
