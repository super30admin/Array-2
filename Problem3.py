# Time Complexity : O(m * n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Life Game


class Solution:
    m = 0
    n = 0
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.m = len(board)
        self.n = len(board[0])

        dirs = [[0,-1], [0,1], [-1,0], [-1,-1], [-1,1],[1,-1], [1,1], [1,0]]

        # First pass: Apply rules and use temporary states (2 for alive->dead, 3 for dead->alive)
        for i in range(self.m):
            for j in range(self.n):
                count = self.countAlive(dirs, board, i,j)
                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = 2 # alive -> dead
                elif board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 3 # dead -> alive

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        
        
    def countAlive(self,dirs, board, i, j) -> int:
        count = 0
        for di in dirs:
            r = di[0] + i
            c = di[1] + j

            if r >= 0 and c >= 0 and r < self.m and c < self.n:
                if board[r][c] == 1 or board[r][c] == 2:
                    count += 1

        return count 

