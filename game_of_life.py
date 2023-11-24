# TC: O(mxn)
# SC: o(1)

class Solution:

    def count_live(self,board,i,j):
        direc=[[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1]]

        r=i
        c=j
        count1=0
        for k in range(0,len(direc)):
            r=i+direc[k][0]
            c=j+direc[k][1]
            print(str(r)+" "+str(c)+" ",end=" ")
            if r>=0 and c>=0 and r<len(board) and c<len(board[0]):
                if board[r][c]==1 or board[r][c]==2:
                    count1+=1
        return count1

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                live_count=self.count_live(board,i,j)
                print(str(i)+" "+str(j)+" "+str(live_count))
                if live_count<2 or live_count>3:
                    if board[i][j]==1:
                        board[i][j]=2
                if live_count==3:
                    if board[i][j]==0:
                        board[i][j]=3

        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if board[i][j]==2:
                    board[i][j]=0
                if board[i][j]==3:
                    board[i][j]=1
        print(board)
        return 0
        