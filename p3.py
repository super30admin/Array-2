## Problem3 (https://leetcode.com/problems/game-of-life/)
# TC : O(M * N)
# SC : O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 0 -> 1 : 2
        # 1 -> 0 : 3
        neighbors = [[1,0],[0,1],[-1,0],[0,-1],[1,1],[-1,-1],[1,-1],[-1,1]]
        row = len(board)
        col = len(board[0])
        for i in range(len(board)):
            for j in range(len(board[0])):
                alive_n = 0
                for n in neighbors:
                    r = i + n[0]
                    c = j + n[1]
                    if (r>=0 and r<row and c>=0 and c<col):
                        if board[r][c]==1 or board[r][c]==3:
                            alive_n += 1
                        # alive_n += 2
                if board[i][j]==0:
                    if alive_n==3:
                        board[i][j] = 2
                else:
                    if not (alive_n==2 or alive_n==3):
                        board[i][j] = 3
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==3:
                    board[i][j]=0
                if board[i][j]==2:
                    board[i][j]=1
  
            
                    
        