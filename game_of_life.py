#Time Complexity:- O(m*n)
# Space Complexity:- O(1)
# While looping through the matrix mark a cell as -2 if it was alive but is now dead or mark a cell as 2 if it was dead earlier but it is now alive
class Solution:
    def gameOfLife(self, matrix):
        """
        Do not return anything, modify board in-place instead.
        """
        #loop through the neighbouring elements
        neighbours=[(0,1),(1,0),(-1,0),(0,-1),(-1,-1),(1,1),(1,-1),(-1,1)]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                live=0
                for k,l in neighbours:
                    if 0<=i+k<len(matrix) and 0<=j+l<len(matrix[0]):
                        # check if the cell is 1-alive or -2 - was alive and is now dead
                        if matrix[i+k][j+l]==1 or matrix[i+k][j+l]==-2:
                            live+=1
                # if cell is live and it is going to die mark it as -2 to indicate it was live earlier
                if matrix[i][j]==1 and live<2:
                    matrix[i][j]=-2
                if matrix[i][j]==1 and live>3:
                    matrix[i][j]=-2
                # if the cell was dead and it is going to become live mark it as 2 to indicate it was dead earlier
                if matrix[i][j]==0 and live==3:
                    matrix[i][j]=2
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]<0:
                    matrix[i][j]=0
                elif matrix[i][j]>1:
                    matrix[i][j]=1
                    
                
                    
                    
                    
                    