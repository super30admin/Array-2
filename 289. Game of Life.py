#Time Complexity:O(n*m)
#Space Complexity:O(1)
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        #1-0=2
        #0-1=3
        count=0
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                count=self.countLive(board,i,j,m,n)
                if board[i][j]==1 and (count<2 or count>3):
                    board[i][j]=2
                elif (board[i][j]==0 and count==3):
                    board[i][j]=3
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                if board[i][j]==3:
                    board[i][j]=1

    def countLive(self,board,i,j,m,n):
        dire=[[-1,0],[1,0],[-1,-1],[-1,1],[0,-1],[0,1],[1,-1],[1,1]]
        count=0
        for k in range(8):
            col=j+dire[k][1]
            row=i+dire[k][0]
            if ((col>=0 and col<n)and(row>=0 and row<m)and (board[row][col]==1 or board[row][col]==2)):
                count=count+1
        return count

