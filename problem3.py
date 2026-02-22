# problem 3

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        possible_match = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        m = len(board)
        n = len(board[0])
        def getCount(i,j):
            count = 0
            for r_val,c_val in possible_match:
                r = i+r_val
                c = j+c_val
                if 0 <= r < m and 0 <= c < n:
                    if board[r][c] == 1 or board[r][c] == 2:
                        count+=1
            return count 
        
        for i in range(m):
            for j in range(n):
                count = getCount(i, j)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
                elif board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 1
                elif board[i][j] == 2:
                    board[i][j] = 0