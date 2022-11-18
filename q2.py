from typing import List
# Time Complexity : O(m*n), Where m, n are number of rows, columns in the board input
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

class Solution:
    def calculate(self,row: int, col: int, board: List[List[int]],m: int,n: int)->int:
        #m->Number of rows
        #n->Number of columns
        adj=[(row-1,col-1),(row-1,col),(row-1,col+1),(row,col-1),(row,col+1),(row+1,col-1),(row+1,col),(row+1,col+1)]
        count=0
        for elem in adj:
            if((elem[0]<0 or elem[0]>m-1) or (elem[1]<0 or elem[1]>n-1)):
                count=count+0
            else:
                if(board[elem[0]][elem[1]]==1 or board[elem[0]][elem[1]]==2):
                    count=count+1
                else:
                    count=count+0
        return count
            
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m=len(board)#Number of rows
        n=len(board[0])#Number of columns
        for i in range(m):
            for j in range(n):
                countlivecells=self.calculate(i,j,board,m,n)
                if(board[i][j]==1):
                    if(countlivecells>3 or countlivecells<2):
                        #Here we should change 1->0
                        board[i][j]=2
                else:
                    if(countlivecells==3):
                        #Here we should change 0->1
                        board[i][j]=-1
        #print(board)
        
        for i in range(m):
            for j in range(n):
                if(board[i][j]==2):
                    #Dead cell case
                    board[i][j]=0
                elif(board[i][j]==-1):
                    #Live cell case
                    board[i][j]=1
        #print(board)        