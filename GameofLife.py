// Time Complexity :o(mn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        rows=len(board)
        cols=len(board[0])
        
        dir=[(-1,-1),(- 1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        for i in range(rows):
            for j in range(cols):
                count=0
                for d in dir:
                    #base this should not happen
                    if ((i+d[0]<0) or (i+d[0]>rows-1) or (j+d[1]<0) or (j+d[1]>cols-1)):
                        continue
                    #logic
                    if(board[i+d[0]][j+d[1]]==1 or board[i+d[0]][j+d[1]]==2):
                        count+=1
                if(board[i][j]==1 and (count<2 or count>3)):
                    board[i][j]=2
                if(board[i][j]==0 and count==3):
                    board[i][j]=3     
        for i in range(rows):
            for j in range(cols):
                board[i][j]%=2
        
