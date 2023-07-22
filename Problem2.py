#Time Complexity: O(n^2)
#Space Complexity: O(n^2)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        rows=len(board)
        columns=len(board[0])
        #live with <2 live dies
        #live with >3 live dies
        #dead with =3 live lives
        #If we use temp=board, then they will point to the same address
        temp=[row[:] for row in board] #To copy from one arr to other
        
        for i in range(0, rows):
            for j in range(0, columns):
                alive=self.countAlive(i,j,rows,columns,temp)
                if temp[i][j]==1:
                    if(alive<2 or alive>3):
                        board[i][j]=0
                else:
                    if(alive==3):
                        board[i][j]=1
        
    def countAlive(self,i,j,rows,columns,board):
        direction=[(-1,-1),(-1,0),(-1,1),(0,1),(0,-1),(1,-1),(1,0),(1,1)]
        count=0
        for d in direction:
            r=d[0]+i
            c=d[1]+j
            if(r>=0 and c>=0 and r<rows and c<columns and board[r][c]==1):
                count=count+1

        return count