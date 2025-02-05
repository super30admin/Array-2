# Time Complexity : O(m*n) m->rows n->cols
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        R,C = len(board), len(board[0])

        def in_bounds(r,c):
            return 0<=r<R and 0<=c<C

        for i in range(R):
            for j in range(C):
                live_count = 0
                for di,dj in [[-1,-1],[-1,0],[1,1],[0,1],[-1,1],[1,0],[1,-1],[0,-1]]:
                    dx,dy = i + di, j + dj
                    if in_bounds(dx,dy) and abs(board[dx][dy]) == 1:
                        live_count += 1
                if board[i][j] == 1:
                    if live_count < 2 or live_count > 3:
                        board[i][j] = -1
                if board[i][j] == 0:
                    if live_count == 3:
                        board[i][j] = 2
        
        for i in range(R):
            for j in range(C):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == -1:
                    board[i][j] = 0