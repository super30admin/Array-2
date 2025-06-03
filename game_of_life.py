# Time Complexity -  O(m * n) 
# Space Complexity -  O(1) 


def gameOfLife(board):
    m, n = len(board), len(board[0])

    # Count live neighbors and mark cells to be updated
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (-1, -1), (1, -1), (-1, 1)]
    for i in range(m):
        for j in range(n):
            live_neighbors = 0
            for d in directions:
                ni, nj = i + d[0], j + d[1]
                if 0 <= ni < m and 0 <= nj < n and abs(board[ni][nj]) == 1:
                    live_neighbors += 1

            if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                board[i][j] = -1
            elif board[i][j] == 0 and live_neighbors == 3:
                board[i][j] = 2

    # Update cells
    for i in range(m):
        for j in range(n):
            if board[i][j] == -1:
                board[i][j] = 0
            elif board[i][j] == 2:
                board[i][j] = 1
