#TC = O(m*n)
#SC = O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions=[(-1,0),(0,1),(0,-1),(1,0),(-1,-1),(1,-1),(1,1),(-1,1)]
        m=len(board)
        n=len(board[0])
        
        for i in range(m):
            for j in range(n):
                live_neb=0
                for ox,oy in directions:
                    ni=ox+i
                    nj=oy+j
                    
                    if 0<=ni<m and 0<=nj<n and abs(board[ni][nj]) == 1:
                        live_neb +=1
                
                if board[i][j] == 1 and (live_neb <2 or live_neb>3):
                    board[i][j] =-1
                if board[i][j] == 0 and (live_neb ==3):
                    board[i][j] =5
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 5:
                    board[i][j] = 1