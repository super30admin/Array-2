"Time complexity is O(M*N)"
"Space complexity is O(1)"

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead
        """
        rows, cols = len(board), len(board[0])
        
        # Directions for 8 neighbors
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

        # First pass: calculate the new state and mark changes
        for r in range(rows):
            for c in range(cols):
                live_neighbors = 0
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < rows and 0 <= nc < cols and abs(board[nr][nc]) == 1:
                        live_neighbors += 1

                # Apply the rules of the Game of Life
                if board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[r][c] = -1  # Mark as -1 to represent it was live, now dead
                if board[r][c] == 0 and live_neighbors == 3:
                    board[r][c] = 2  # Mark as 2 to represent it was dead, now live

        # Second pass: finalize the state change
        for r in range(rows):
            for c in range(cols):
                if board[r][c] > 0:
                    board[r][c] = 1
                else:
                    board[r][c] = 0


        