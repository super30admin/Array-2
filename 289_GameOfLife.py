#Time Complexity = O(m*n)
#Space Complexity = O(1)
from typing import List


class Solution:
     # U,D, L, R, UL, UR,LL, LR

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return
        # 1--- > 0 = 2
        # 0 ----> = = 3
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                countLiveNeigbours = self.countLiveNeigbours(board, i, j)
                if board[i][j] == 1:
                    if countLiveNeigbours < 2 or countLiveNeigbours > 3:
                        board[i][j] = 2
                elif board[i][j] == 0:
                    if countLiveNeigbours == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    def countLiveNeigbours(self,board, i ,j):
        m = len(board)
        n = len(board[0])
        count = 0
        dirs = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]
        for dir in dirs:
            nr = i + dir[0]
            nc = j + dir[1]
            if (nr >= 0 and  nr < m) and (nc >= 0 and nc < n) and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count = count + 1
        return count


        
