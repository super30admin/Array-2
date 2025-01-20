class Solution:
    
    def __init__(self):
        self.directionMatrix = [
                [0,1], # row = +0, col = +1 --> right direction
                [1,0], # row = +1, col = +0 --> down direction
                [-1,0], # row = +(-1), col = +0 --> up direction
                [0,-1], # row = +0, col = +(-1) --> left direction
                [1,-1], # row = +1, col = +(-1) --> down-left direction
                [1,1],  # row = +1, col = +1 --> down-right direction
                [-1,-1], # row = +(-1), col = +(-1) --> up-left direction
                [-1,1] # row = +(-1), col = +1 --> up-right direction
            ]
        
        self.matrix = None
        
    def tempStateChange(self,currRow,currCol):
        
        #print('\n')
        #print('CurrentRow is:\t',currRow)
        #print('CurrentCOl is:\t',currCol)
        
        sum = 0
        
        # Iterate the directionMatrix
        for i in range(0,len(self.directionMatrix)):
            # Check for all directions
            row = currRow + self.directionMatrix[i][0]
            col = currCol+ self.directionMatrix[i][1]
             
            if (row > -1 and row < len(self.matrix)) and (col > -1 and col < len(self.matrix[0])):
                # Cal sum
                 
                if self.matrix[row][col] == 2:
                    # Dead to alive
                    sum += 0
                 
                elif self.matrix[row][col] == 3: 
                    # Alive to dead
                    sum += 1
                
                else:
                    sum += self.matrix[row][col]
        
                 
        # Check the value of sum
        if self.matrix[currRow][currCol] == 0 and sum == 3:
            # Do temporal state change i.e. 0-->2 if sum is 3
            self.matrix[currRow][currCol] = 2
    
        elif self.matrix[currRow][currCol] == 1 and (sum > 3 or sum < 2):
            # Do temporal state change i.e. 1-->3 if sum > 3 and sum < 2
            self.matrix[currRow][currCol] = 3
    
    def getSolution(self,matrix):
        
        self.matrix = matrix
        
        # Iterate the matrix
        for currRow in range(0,len(matrix)):
            for currCol in range(0,len(matrix[0])):
                self.tempStateChange(currRow, currCol)
        
        # Print the matrix
        print('Temp State change matrix is:\t',self.matrix)
        
        # Now iterate the matrix and set 2 --> 1 and 3 --> 0
        for currRow in range(0,len(matrix)):
            for currCol in range(0,len(matrix[0])):
                if self.matrix[currRow][currCol] == 2:
                    self.matrix[currRow][currCol] = 1
                elif self.matrix[currRow][currCol] == 3:
                    self.matrix[currRow][currCol] = 0
        
        # Print the result matrix
        print('Result matrix is:\t',self.matrix)
                
sol = Solution()
sol.getSolution(
        [
            [0,1,0],
            [0,0,1],
            [1,1,1],
            [0,0,0]
        ]
    )