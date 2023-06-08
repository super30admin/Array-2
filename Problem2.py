#Time complexity is:O(m*n) where m is the numer of rows and n is the number of columns
#Space complexity is:O(1)
#Program ran successfully on leet code
#No problem faced while coding this program

#Game of life program
class Solution(object):
    #method to find the count of alive neighbours
    def countAlive(self,board,i,j,m,n):
            count=0
            #dirs array contains the row and column values that needs to be added to the i and j to find the neighbours
            dirs=[[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
            #For a particular i and j we will be find the neighbours
            for k in dirs:
                r=i+k[0]
                c=j+k[1]
                #checking the conditions like where r and c values are positive or not, 
                #r<no of rows and c<no of columns and whether the neighbour values is 1 or not
                if(r>=0 and c>=0 and r<m and c<n and (board[r][c]==1 or board[r][c]==2)):
                    #if yes we will add 1 to the count
                    count+=1
            return count
    
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        #If 1 needs to be replaced with 0, we will change value 1 to 2
        #If 0 needs to be replaced with 1, we will change value 0 to 3
        #Finding the number of rows and columns
        m=len(board)
        n=len(board[0])
        for i in range(0,m):
            for j in range(0,n):
                #Finding the count of alive neighbours of each index in the matrix
                val=self.countAlive(board,i,j,m,n)
                #If the original value at a aprticular index is 1, condition satisfies
                if(board[i][j]==1):
                    #if the number of alive neighbours are <2 or >3
                    if(val<2 or val>3):
                        #We will change the value from 1 to 2
                        board[i][j]=2
                else:
                    #if the number of neighbours are equal to 3
                    if(val==3):
                        #We will change the value from 0 to 3
                        board[i][j]=3
        
        #making the changes in the original matrix to generate the modified matrix
        for i in range(0,m):
            for j in range(0,n):
                if(board[i][j]==2):
                    board[i][j]=0
                if(board[i][j]==3):
                    board[i][j]=1

        #Finally we are returning the modified matrix
        return board
        


