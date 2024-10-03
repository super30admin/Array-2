# Time Complexity : O(m*n) --> Iterating through the matrix
# Space Complexity : O(1) --> In place Modification
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A

# Your code here along with comments explaining your approach
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        #Assign length of rows and columns of the matrix
        m = len(board)
        n = len(board[0])
        #To access the directions for neighbors of current element
        dirs = [(0,-1),(0,1),(-1,0),(1,0),(-1,-1),(-1,1),(1,-1),(1,1)]
        #Iterate through the matrix to identify dead and live elements
        for i in range(0,m):
            for j in range(0,n):
                #Function to identify live neighbours of the current element
                count = self.countAlive(dirs, board, i, j)
                #Check if the current element is alive
                if(board[i][j]==1):
                    #If alive then check if it has less than 2 or greater than 3 neighbors
                    if(count<2 or count>3):
                        board[i][j]=2 #If yes then change 1 to 2, i.e, Alive --> Dead
                #Check if the current element is dead
                elif(board[i][j]==0):
                    #If dead then check if it has exactly 3 neighbors
                    if(count==3):
                        board[i][j]=3 #If yes then change the 0 to 3, i.e, Dead --> Alive
        #Iterate through the matrix to identify Alive --> Dead and Dead --> Alive elements
        for i in range(0,m):
            for j in range(0,n):
                #To check if the current element has been changed from Alive --> Dead
                if(board[i][j]==2):
                    board[i][j]=0 #Update it as 0 dead
                #To check if the current element has been changed from Dead --> Alive
                elif(board[i][j]==3):
                    board[i][j]=1 #Update it as 1 Alive
    def countAlive(self, dirs, board, i, j):
        m = len(board)
        n = len(board[0])
        #Assign count as 0 initially 
        count=0
        #Iterate each direction from the current element and get their row, column
        for dir in dirs:
            r = dir[0] + i
            c = dir[1] + j
            #Boundary condition to check if the neighbor exists
            if(0<=r<=m-1 and 0<=c<=n-1):
                #If the neighbor is alive increment count
                if(board[r][c]==1 or board[r][c]==2):
                    count+=1
        return count




        