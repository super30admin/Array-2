# Time Complexity : O(m*n)
# Space Complexity : O(1)
class Solution:
    def countLiveNeighbors(self, board, row, col):
        count = 0
        m, n = len(board), len(board[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
        
        for dr, dc in dirs:
            nr, nc = row + dr, col + dc
            if 0 <= nr < m and 0 <= nc < n:
                if board[nr][nc] == 1 or board[nr][nc] == -1:
                    count += 1
        
        return count

    def gameOfLife(self, board):
        if not board or len(board) == 0:
            return
        
        nowDead, nowLive = -1, 2
        m, n = len(board), len(board[0])
        
        for i in range(m):
            for j in range(n):
                live_neighbors = self.countLiveNeighbors(board, i, j)
                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = nowDead
                elif board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = nowLive
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == nowDead:
                    board[i][j] = 0
                elif board[i][j] == nowLive:
                    board[i][j] = 1

# Example 1
solution = Solution()
board1 = [
    [0, 1, 0],
    [0, 0, 1],
    [1, 1, 1],
    [0, 0, 0]
]
solution.gameOfLife(board1)
print(board1)  # Expected output: [[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]

# Example 2
board2 = [
    [1, 1],
    [1, 0]
]
solution.gameOfLife(board2)
print(board2)  # Expected output: [[1, 1], [1, 1]]

# Example 3
board3 = [
    [0, 0, 0],
    [1, 1, 0],
    [0, 1, 1]
]
solution.gameOfLife(board3)
print(board3)  # Expected output: [[0, 0, 0], [1, 1, 1], [1, 1, 1]]
