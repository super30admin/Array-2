# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        0-->1 --3
        1-->0 --4
        """
        global r,c
        r=len(board)
        c=len(board[0])
        for i in  range(r):
            for j in range(c):
                countLive= self.countLive(board,i,j)
                if (board[i][j]==1 and (countLive<2 or countLive>3)):
                    board[i][j]=4
                elif board[i][j]==0 and countLive==3:
                    board[i][j]=3
        for i in  range(r):
            for j in range(c):
                if board[i][j]==3: board[i][j]=1
                elif board[i][j]==4: board[i][j]=0
        return board
    def countLive(self,board: List[List[int]], i: int,j : int):
        direction=[[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[1,-1],[-1,1],[1,1]]
        count=0
        for d in direction:
            cr=i+d[0]
            cc=j+d[1]
            if cr>=0 and cr<r and cc>=0 and cc<c and (board[cr][cc]==1 or board[cr][cc]==4) :
                count+=1
        return count
            
                    
                    