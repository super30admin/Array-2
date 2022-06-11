#Time Complexity : O(m*n) at every index in the matrix operations are taking place
#Space Complexity : O(1) result is in form of change in input matrix
#Did this code successfully run on Leetcode : Yes
class Solution:
    #defining the direction list for checking the 8 directions around the current element
    directions = [[0,1], [0,-1], [1,0], [-1,0], [-1,-1], [-1,1],[1,-1],[1,1]]
    def Alivecount(self, board: List[List[int]], i : int, j :int, m : int, n:int) :
        #creating variable for storing the count of live elements around the current element at i,j
        result = 0
        #creating for loop for checking the elements alive elements
        for  direction in self.directions:
            #for storing the index of the row
            nr = i + direction[0]
            
            #for storing the index of the column
            nc = j + direction[1]
         
            if (nr in range(0,m)) and (nc in range(0,n)) :
                if board[nr][nc] == 1 or board[nr][nc] == 3:
                    #3 is taken for the the temporary change number was alive before
                    result +=1

        return result
            
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #Defining the row and column length of the board
        m =len(board)
        n = len(board[0])


        #creating for loop for checking the givens conditions of the game 
        for i in range(m):
            for j in range(n):
                #calling function countalive to get the number of elments alive around the current element
                countAlive = self.Alivecount(board, i, j, m, n)
                #checking the first condition of chaning the alive to dead if the elements alive around the current element is less than 2 or greater than 3
                if board[i][j] == 1 and (countAlive < 2 or countAlive >3):
                    #changing the alive element to dead by giving the temporary number 3
                    board[i][j] = 3
                #checking the second condition around the current element if there are 3 alive then chaning current dead element to alive
                if board[i][j] == 0 and countAlive == 3:
                    #changing the dead element to alive by giving the temporary number 2
                    board[i][j] = 2
                
        #Creating again loops for changing the temporary number to 0 and 1 so that mutation is removed
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] ==2:
                    board[i][j] =1

