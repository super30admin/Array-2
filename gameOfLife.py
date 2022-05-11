#Time complexity: O(m*n)
#Space complexity: O(1)

class Solution:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        direction=[(0,1),(0,-1),(1,0),(-1,0),(1,1),(-1,1),(-1,-1),(1,-1)]
        for i in range(len(board)):
            for j in range(len(board[0])):
                num=self.countAlive(board,direction,i,j)
                if board[i][j]==0 and num==3:
                    board[i][j]=2
                elif board[i][j]==1 and (num<2 or num>3):
                    board[i][j]=3
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=1
                if board[i][j]==3:
                    board[i][j]=0
    def countAlive(self,board,direction,i,j):
        res=0
        for direct in direction:
            r=i+direct[0]
            c=j+direct[1]
            if (r>=0 and r<len(board)) and (c>=0 and c<len(board[0])) and (board[r][c]==1 or board[r][c]==3):
                res+=1
        return res
                