# Time Complexity :
# O(N*M)  - Size of the Matrix

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We go through each cell in the array. If there is no change to be done, we leave it as is
# If a change has to be done (based on number of alive neighbours), we update the array with the following values:
# a. If the change is from 1 to 0, then we store 2
# b. If the changer is from 0 to 1, then we store 3
#Once all updates are done, we then traverse the array, make changes based on value stores (if it's 2 then we update it to 0 etc) and that will be the resultant array

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dirs = []
        #First pass to process how many alive neighbours exist
        for i in range(len(board)):
            for j in range(len(board[0])):
                alive_count = self.count_alive(i,j,board)

                if board[i][j] == 1 and (alive_count < 2 or alive_count > 3 ):
                    board[i][j] = 2
                if board[i][j] == 0 and alive_count == 3: 
                    board[i][j] = 3

        #Second pass to use updated values to get the next state
        for i in range(len(board)):
            for j in range(len(board[0])):   
                if board[i][j] == 2 :
                    board[i][j] = 0
                elif board[i][j] == 3 :
                    board[i][j] = 1


    
    def count_alive(self,i,j,board):
        n = len(board) -1
        m = len(board[0]) -1 
        dirs = [(0,1),(1,0),(1,1),(1,-1),(0,-1),(-1,-1),(-1,0),(-1,1)]
        
        alive_count = 0
        for direction in dirs:
            #if i <= n and 
            r = i + direction[0]
            c = j+direction[1]
            #Checking if the neighbour exists in the array
            if r <= n and r >= 0 and c >= 0 and c <= m :
                #Checking the exact value of the neighbour and updating count
                if board[r][c] == 1 or board[r][c] == 2 :
                    alive_count += 1
        return alive_count
                
