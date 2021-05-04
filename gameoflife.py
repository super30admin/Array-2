"""Game of life. 
Time Complexity - O(n)
Space Complexity  -O(1)

APProach - inplace modification. 

change of state .
0->1 - 3
1->0 - 2"""

class Solution:
    def liveCount(self,board, n, m, i,j):
        cnt = 0
    
        dir_possible = [[1,-1],[1,0],[1,1],[0,-1],[0,1],[-1,-1],[-1,0],[-1,1]]
    
        for dirs in dir_possible:
            r = i + dirs[0]
            c = j + dirs[1]
        
            if (r >= 0 and r<n and c>=0 and c<m and (board[r][c]==1 or board[r][c]==2)):
                cnt +=1
    
        return cnt
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None or len(board)==0 or len(board[0])==0:
            return
        n = len(board)
        m = len(board[0])
    
        for i in range(n):
            for j in range(m):
                live = self.liveCount(board, n, m, i, j)
                if board[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] = 2
                elif board[i][j] ==0 and live ==3:
                    board[i][j] = 3
                
                
        for i in range(n):
            for j in range(m):
                if board[i][j]==2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        return board
    
