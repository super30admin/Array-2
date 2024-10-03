# Time Complexity = O(mn) Space Complexity = O(1)

class Solution:

    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.m = len(board)
        self.n = len(board[0])
                # left,right, up, down, up-left, up-right, down-left, down-right
        dirs = [[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        for i in range(self.m):
            for j in range(self.n):
                live_count = self.count_alive(dirs, board, i, j)
                if board[i][j] == 1:
                    if live_count < 2 or live_count > 3:
                        board[i][j] = 2  # alive -> dead
                else:
                    if live_count == 3:
                        board[i][j] = 3   # dead -> alive

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    def count_alive(self, dirs: list[list[int]], board: list[list[int]], i: int, j: int) -> int:
        count = 0
        for dir in dirs:
            r = dir[0] + i
            c = dir[1] + j

            if r >= 0 and c >= 0 and r < self.m and c < self.n:
               if board[r][c] == 1 or board[r][c] == 2:
                    count += 1

        return count