class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        M = len(board)
        if M == 0:
            return
        N = len(board[0])
        
        # Directions for the eight neighbors
        directions = [
            (-1,  0),  # Up
            ( 1,  0),  # Down
            ( 0, -1),  # Left
            ( 0,  1),  # Right
            (-1, -1),  # Upper Left
            (-1,  1),  # Upper Right
            ( 1, -1),  # Lower Left
            ( 1,  1)   # Lower Right
        ]
        
        # Iterate through each cell to apply the rules
        for i in range(M):
            for j in range(N):
                live_neighbors = 0
                for di, dj in directions:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < M and 0 <= nj < N:
                        if board[ni][nj] == 1 or board[ni][nj] == 2:
                            live_neighbors += 1
                
                # Apply rules based on live neighbors
                if board[i][j] == 1:
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[i][j] = 2  # Live to dead
                else:
                    if live_neighbors == 3:
                        board[i][j] = 3  # Dead to live
        
        # Finalize the board by updating the temporary values
        for i in range(M):
            for j in range(N):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
