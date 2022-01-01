"""
Approach

1. we need to keep the memory of the current state and previous state of a cell to update the other cells based on the condition
2. if a cell transition from 0-1 we represent it by 2 
3. if a cell transition from 1-0 we represent it by 3 
4. once we calculate all the cells, we traverse the matrix again to convert 2 to 1 and 3 to 0

"""


# Time Complexity : O(m*n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        columns = len(board[0])
        
        direction = [[1,-1],[1,0],[1,1],[0,-1],[-1,-1],[-1,0],[-1,1],[0,1]]
        
        for i in range(rows):
            for j in range(columns):
                neighbours = 0
                # Traverse all neighbours and increase the count if neighbour is alive
                for d in direction:
                    #check left, right, top and down boundary conditions
                    if ( (i+d[0]<0) or (i+d[0] >rows-1) or (j+d[1]<0) or (j+d[1]>columns-1)):
                        continue
                    if (board[i+d[0]][j+d[1]]== 1 or board[i+d[0]][j+d[1]]== 3):
                        neighbours +=1
                
                if( board[i][j]==1 and (neighbours<2 or neighbours >3)):
                    board[i][j] = 3
                
                if( board[i][j]==0 and (neighbours==3)):
                    board[i][j] = 2
             
        for i in range(rows):
            for j in range(columns):
                if board[i][j]==3:
                    board[i][j]= 0
                if board[i][j] ==2:
                    board[i][j]=1
                