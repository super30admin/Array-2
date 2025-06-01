#Time Complexity: O(N * M)
#Space Complexity: O(1)

def gameOfLife(board):
    rows, cols = len(board), len(board[0])

    # Directions for 8 neighbors
    directions = [
        (-1, -1), (-1, 0), (-1, 1),
        (0, -1),         (0, 1),
        (1, -1), (1, 0), (1, 1)
    ]

    # Step 1: First pass - Apply rules with encoded values
    for i in range(rows):
        for j in range(cols):
            live_neighbors = 0

            # Count live neighbors
            for dx, dy in directions:
                ni, nj = i + dx, j + dy
                if 0 <= ni < rows and 0 <= nj < cols:
                    if abs(board[ni][nj]) == 1:  # Consider original state
                        live_neighbors += 1

            # Step 2: Apply the rules using temporary markers
            if board[i][j] == 1:
                if live_neighbors < 2 or live_neighbors > 3:
                    board[i][j] = -1  # Was live, now dead
            else:
                if live_neighbors == 3:
                    board[i][j] = 2   # Was dead, now live

    # Step 3: Final pass - Decode values
    for i in range(rows):
        for j in range(cols):
            board[i][j] = 1 if board[i][j] > 0 else 0
