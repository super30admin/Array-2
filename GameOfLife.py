# Time Complexity : O(M x N) //As it would run for each row and column of the array
#  Space Complexity : O(1) //As we are using the same array to return the result
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : Had to refine m and n again in the countLives function
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #Declare col and row length to a variable
        m = len(board)
        n = len(board[0])
        
        #Iterate through the matrix and based on the live count change the state to 2 or 3
        # 0->1 ==> 2
        # 1->0 ==> 3
        for i in range(m):
            for j in range(n):
                countLiveNeighbour = self.countLives(board,i,j) #return count of live neighbours
                
                if board[i][j]==0:
                    if countLiveNeighbour == 3:
                        board[i][j] = 2
                else:
                    if countLiveNeighbour < 2:
                        board[i][j] = 3
                    if countLiveNeighbour > 3:
                        board[i][j] = 3
        #Once the matrix is changed with 2's and 3's restore them to thier original marking
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
    
    #This function returns the number of live neighbours based on the given rules
    def countLives(self, board,r,c):
        m = len(board)
        n = len(board[0])
        count = 0
        #Creating a constant direction list to check every neighbour 
        dirs = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        
        #Move the element according to the directions
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            #Check the rule constraint here and increment the count if the neighbors are 1 or 3
            if (nr >=  0 and nr  < m and nc>=0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3)):
                count+=1
        return count