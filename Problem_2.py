"""
Question Rule
    - 1 -> 0
       < 2
       >3
    - 0 -> 1
       == 3

Our Rule
    - 0 -> 1 = 3
    - 1 -> 0 = 2

TC - O(nxm)
SC - O(1)
"""
class Solution:
    def count_lives(self, board, neighbors, i, j, m, n) -> int:
        ans = 0
        for d in neighbors:
            r = i + d[0]
            c = j + d[1]
            if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] == 1 or board[r][c] == 2):
                ans += 1
        return ans

    def gameOfLife(self, board: List[List[int]]) -> None:
        if board is None or not board:
            return
        m, n = len(board), len(board[0])
        neighbors = []
        for i in range(-1, 2):  # just to automate 8 neighbors
            for j in range(-1, 2):
                if i == 0 and j == 0: continue
                neighbors.append((i, j))
        for i in range(m):
            for j in range(n):
                count = self.count_lives(board, neighbors, i, j, m, n)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

