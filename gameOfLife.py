# // Time Complexity : O(mn) 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
## we basically need to find the neighbours of each cell and determine if the cell is going to loive in the next gen or not. 
##we use a variable to indicate state changes. 1-> 0 is represented by 3 and 0->1 is represented by 2, we dont care about 0->0 or 1->1 because 
## it does not add value to store these state changes. so when we change the state based on number of neighbours we replace 0 or 1 by 3 or 2. 
## at the ned we traverse through the matrix and replace them with 0 and 1 again.
class solution:
    def findNeighbours(matrix, row, col):
        directions = [[1,0], [1,-1], [-1,0], [-1,-1], [0,1], [0,-1], [1,1], [-1,1]]
        neighbours =0
        for dir in directions:
            new_row = row+dir[0]
            new_col = col+dir[1]

            if new_row >= 0 and new_col >= 0 and new_row < len(matrix) and new_col < len(matrix[0]) and matrix[new_row][new_col] in [1,3]:
                neighbours+=1

        return neighbours
    def gameOfLife(self, matrix):

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):

                neighbours = self.findNeighbours(matrix, i, j)

                if matrix[i][j] == 1:
                    if neighbours <2 or neighbours>3:
                        matrix[i][j] = 3
                    
                else:
                    if neighbours == 3:
                        matrix[i][j] =2

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):  

                if matrix[i][j] == 3:
                    matrix[i][j] = 0

                if matrix[i][j] == 2:
                    matrix[i][j] = 1

        


