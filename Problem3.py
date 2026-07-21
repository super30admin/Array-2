# https://leetcode.com/problems/game-of-life/

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (1,1), (1,0), (1,-1), (0,1)]

        for i in range(len(board)):
            for j in range(len(board[i])):
                liveCount = 0
                for dr, dc in dirs:
                    ni = i + dr   
                    nj = j + dc 
                    if 0 <= ni < len(board) and 0 <= nj < len(board[0]):
                        if board[ni][nj] == 1 or board[ni][nj] == 2:
                            liveCount += 1

                if board[i][j] == 1 and (liveCount < 2 or liveCount > 3):
                    board[i][j] = 2 # previously alive, now dead
                elif board[i][j] == 1 and (liveCount == 2 or liveCount == 3):
                    board[i][j] = 1
                elif board[i][j] == 0 and liveCount == 3:
                    board[i][j] = 3 # previously dead, now alive 

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1