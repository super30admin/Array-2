"""
TC: O(m*n) to iterate throgh board
SC: O(1), No additional space
"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        neighbors = [(-1,-1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = 0
                for nr, nc in neighbors:
                    ni =  i+nr
                    nj = j+nc
                    if (ni >=0 and ni <m) and (nj >=0 and nj < n):
                        if board[ni][nj]==1 or board[ni][nj]==2:
                            count+=1
                if board[i][j] ==1 and (count<2 or count>3): # alive to dead
                    board[i][j] = 2
                elif  board[i][j] ==0 and count == 3: #dead to alive
                    board[i][j] = -1
        for i in range(m):
            for j in range(n):
                if board[i][j] ==2 :
                    board[i][j] = 0
                elif board[i][j] == -1:
                    board[i][j] = 1
        


        