// Time Complexity :o(mn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:First intialise the directions and then iterate through the rows and column.Consider boundry cases and apply the cases.
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        dir={(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)}
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                live=0
                for d in dir:
                    if((i+d[0]<0) or (i+d[0]>=len(board)) or (j+d[1]<0) or (j+d[1]>=len(board[0]))):
                        continue
                    if(board[i+d[0]][j+d[1]]==1 or board[i+d[0]][j+d[1]]==2):
                        live+=1
                if(board[i][j]==1 and (live<2 or live>3)):
                    board[i][j]=2
                if(board[i][j]==0 and live==3):
                    board[i][j]=3
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                board[i][j]%=2
                              
