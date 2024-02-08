'''
TC: O(m*n)
SC: O(1)
'''
from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS, COLS = len(board), len(board[0])
        dirs = {(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)}

        def activeNeighbors(r,c):
            count = 0
            for dir_ in dirs:
                nr, nc = r+dir_[0], c+dir_[1]
                if nr>=0 and nc>=0 and nr<ROWS and nc<COLS:
                    if board[nr][nc] == 1 or board[nr][nc] == -1:
                        count += 1
            return count


        for i in range(ROWS):
            for j in range(COLS):
                #If cell is Alive
                active = activeNeighbors(i,j)
                if board[i][j] == 1:
                    if active < 2 or active > 3:
                        board[i][j] = -1
                #If cell is Dead
                else:
                    if active == 3:
                        board[i][j] = -2
        
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == -2:
                    board[i][j] = 1
        print(board)
        
s = Solution()
s.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]])
s.gameOfLife([[1,1],[1,0]])