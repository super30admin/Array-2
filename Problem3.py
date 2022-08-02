# Time complexity : O(m*n) --> m,n is the dimension of the given board
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    rows = 0
    columns = 0
    dirs = []
    def gameOfLife(self, board: List[List[int]]) -> None:
        # find rows and columns of the board
        rows = len(board)
        columns = len(board[0])
        
        # these directions are used to traverse to the matrix to find the neighbors, alive or dead
        dirs = [(-1,-1),(-1,0),(-1,1), (0,-1),(0,1),(1,-1),(1,0),(1,1)]
        
        # We traverse the matrix and find the number of neighbors and then apply the rules of converting dead or live cells the other way
        # Rule 1 --> If alive(1), neighbors less than 2 or greater than 3, make it dead (0) , this conversion is replaced at 2, preserving the 1 for others
        # Rule 2 --> if dead(0), neigbors exactly 3, then make the current cell alive(1), make this cell as 3, to preserve for other comparisons
        for i in range(rows):
            for j in range(columns):
                ne = self.neighbors(board,dirs,i,j)
                if (board[i][j] == 1) and (ne < 2 or ne > 3):
                    board[i][j] = 2
                if (board[i][j] == 0) and (ne == 3):
                    board[i][j] = 3
        
        # Again traverse the matrix and convert 2 to 0, and 3 to 1, back into the original state
        for i in range(rows):
            for j in range(columns):
                if (board[i][j] == 2):
                    board[i][j] = 0
                if (board[i][j] == 3):
                    board[i][j] = 1
                
    # Helper function to calculate the alive neighbors
    def neighbors(self, board, dirs, r, c):
        count = 0
        rows = len(board)
        columns = len(board[0])
        
        # going over each location by using the value of rows and columns and the values from the dirs dictionary for all 8 positions
        # left, right, top, bottom, all 4 digonals (total 8)
        for di in dirs:
            nr = r + di[0]
            nc = c + di[1]
            # checking for boundary conditions and also for values 1 and 2 (value previoulsy was 1 before it was changed), then increment the count
            if (nr >=0 and nr < rows) and (nc >=0 and nc < columns) and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1
        
        return count
