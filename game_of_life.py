# Did this code successfully run on Leetcode : YES

# instead of new storage space for keeping track of changes make changes in the input array itself
# mappings 0 -> 1 = 2
# 1 -> 0 = 3

# TC: O(m*n)
# SC: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 0 -> 1 : 2
        # 1 -> 0 : 3
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                alive_neighbors = self.get_alive_neighbors(board, i, j)
                if board[i][j] == 0:
                    if alive_neighbors == 3:
                        board[i][j] = 2
                else:
                    if alive_neighbors < 2 or alive_neighbors > 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
                    
    def get_alive_neighbors(self, board, i, j):
        m = len(board)
        n = len(board[0])
        num_neighbors = 0
        dirs = [
            [1, 0],
            [0, 1],
            [-1, 0],
            [0, -1],
            [1, 1],
            [1, -1],
            [-1, 1],
            [-1, -1]
        ]
        for d in dirs:
            x = i + d[0]
            y = j + d[1]
            if 0 <= x < m and 0 <= y < n and (board[x][y] == 1 or board[x][y] == 3):
                num_neighbors += 1
        return num_neighbors