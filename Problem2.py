class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows, cols = len(board), len(board[0])
        # Directions for the 8 neighbors
        directions = [(-1, -1), (-1, 0), (-1, 1),
                      (0, -1),          (0, 1),
                      (1, -1), (1, 0), (1, 1)]
        
        # Create a copy of the board to store the next state
        new_board = [[board[r][c] for c in range(cols)] for r in range(rows)]
        
        for r in range(rows):
            for c in range(cols):
                live_neighbors = 0
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < rows and 0 <= nc < cols:
                        live_neighbors += board[nr][nc]
                
                # Apply the Game of Life rules
                if board[r][c] == 1:  # Current cell is alive
                    if live_neighbors < 2 or live_neighbors > 3:
                        new_board[r][c] = 0  # Cell dies
                else:  # Current cell is dead
                    if live_neighbors == 3:
                        new_board[r][c] = 1  # Cell becomes alive
        
        # Update the original board with the new state
        for r in range(rows):
            for c in range(cols):
                board[r][c] = new_board[r][c]