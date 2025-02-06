def gameOfLife(board):
    m, n = len(board), len(board[0])
    
    def count_neighbors(r, c):
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), 
                      (0, 1), (1, -1), (1, 0), (1, 1)]
        count = 0
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n and abs(board[nr][nc]) == 1:
                count += 1
        return count

    for r in range(m):
        for c in range(n):
            live_neighbors = count_neighbors(r, c)

            if board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                board[r][c] = -1  # Mark cell as 1 → 0

            if board[r][c] == 0 and live_neighbors == 3:
                board[r][c] = 2  # Mark cell as 0 → 1

    for r in range(m):
        for c in range(n):
            if board[r][c] == -1:
                board[r][c] = 0
            elif board[r][c] == 2:
                board[r][c] = 1
