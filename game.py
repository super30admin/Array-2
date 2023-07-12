#TC:O(m*n)
#SC:O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS,COLS = len(board),len(board[0])
        def neigh(r,c):
            nei = 0
            for i in range(r-1,r+2):
                for j in range(c-1,c+2):
                    if ((i==r and j ==c) or i <0 or j<0 or i == ROWS or j==COLS):
                        continue
                    if board[i][j] in [1,3]:
                        nei+=1
            return nei

        for r in range(ROWS):
            for c in range(COLS):
                nei = neigh(r,c)
                if board[r][c]:
                    if nei in [2,3]:
                        board[r][c] = 3
                elif nei == 3:
                    board[r][c] = 2
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == 1:
                    board[r][c] = 0
                elif board[r][c] in [2,3]:
                    board[r][c] = 1

                
