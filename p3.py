#TIme Complexityy :O(m*n)
# Space COmplexity : O(1)
# Able to run on leetcode :Yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return
        
        m, n = len(board), len(board[0])
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        
        for i in range(m):
            for j in range(n):
                live_neighbors = 0
                for dx, dy in directions:
                    x, y = i + dx, j + dy
                    if 0 <= x < m and 0 <= y < n and abs(board[x][y]) == 1:
                        live_neighbors += 1
                
                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = -1  # Mark cell as changing from live to dead
                if board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 2  # Mark cell as changing from dead to live
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
