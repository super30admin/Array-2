# Time Complexity :O(m*n)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        arr = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[-1,1],[1,1],[1,-1]]
        row = len(board)
        col = len(board[0])
        
        def gettag(r,c):
            count = 0
            for idx in arr:
                nr = r+idx[0]
                nc = c+idx[1]
                if (nr >= 0 and nr <= row-1) and (nc >= 0 and nc <= col-1):
                    if board[nr][nc] == 1 or board[nr][nc] == 2:
                        count += 1
            return count


        for r in range(row):
            for c in range(col):
                count = gettag(r,c)

                if board[r][c] == 0 and count == 3:
                    board[r][c] = 3
                
                elif board[r][c] == 1 and (count < 2 or count > 3):
                    board[r][c] = 2
                
                elif board[r][c] == 1 and (count == 2 or count == 3):
                    board[r][c] = 1

        for r in range(row):
            for c in range(col):

                if board[r][c] == 3:
                    board[r][c] = 1
                
                if board[r][c] == 2:
                    board[r][c] = 0

        return board