#TC: O(m*n)
#SC: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m=len(board) #rows
        n=len(board[0]) #cols
    
        for i in range(m):
            for j in range(n):
                count = self.countAlive(board,i,j,m,n)
                if board[i][j]==0:
                    if count ==3:
                        board[i][j]=2 #dead prev, alive now
                if board[i][j]==1:
                    if count < 2 or count > 3:
                        board[i][j]=3 # alive prev, dead now
            
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=1
                if board[i][j]==3:
                    board[i][j]=0

        

    def countAlive(self,board,i,j,m,n):
        directions = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        count_ones = 0
        for k in range(len(directions)):
            r = i + directions[k][0]
            c = j + directions[k][1]
            if (r>=0 and c >=0 and r < m and c<n):
                if board[r][c]==1 or board[r][c]==3:
                    count_ones +=1
            
        return count_ones


