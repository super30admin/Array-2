#Time Complexity :O(8*m*n)~O(m*n)
#Space Complexity :O(1) as space remains constant
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                count=self.countAlive(board,i,j,m,n)
                if (board[i][j]==1 and (count<2 or count>3)):
                    board[i][j]=2
                if (board[i][j]==0 and (count==3)):
                    board[i][j]=3
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                if board[i][j]==3:
                    board[i][j]=1

    def countAlive(self,board,i,j,m,n):
        count=0
        
        dirct=[(0,-1),(0,1),(-1,0),(1,0),(-1,-1),(-1,1),(1,-1),(1,1)]
        for dirc in dirct:
            row=i+dirc[0]
            col=j+dirc[1]
            if row>=0 and col>=0 and row<m and col<n and (board[row][col]==1 or board[row][col]==2):
                count+=1
        return count


