#Space complexity: O(1)
# Time complexity: O ( no. of rows * no. of columns)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.m= len(board)
        self.n= len(board[0])

        for r in range(self.m):
            for c in range(self.n):
                # finding neighbour count
                neighbourcount = self.findNeighbours(board,r,c)
                if ( board[r][c] == 1):

                    if neighbourcount < 2 or neighbourcount > 3:
                        # if neighbour count is less then 2 or more then 3 then changing cell to 3 which will be later changed to 0
                        board[r][c]= 3
                else:
                    if neighbourcount == 3:
                        # if neighbour count is 3 then changing cell to 2 which will later changed to 1
                        board[r][c]= 2
        for r in range(self.m):
            for c in range(self.n):
                if ( board[r][c] == 2):
                    board[r][c] = 1
                elif ( board[r][c] == 3):
                    board[r][c] = 0

        

    def findNeighbours(self,board,i,j):
        # directions array for store the relative neighbour cordinates
        dirs= [[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1]] # UP, UR, R, DR,D,DL,L, UL
        count=0
        # iterating the dir
        for cord in dirs:
            row = i + cord[0]
            col = j + cord[1]
            # checking condition if neighbours are not out of bounds of the array
            if((row >=0) and (row < self.m) and (col >=0) and (col < self.n)):
                if(board[row][col] == 1 or board[row][col] == 3):
                    count = count +1
        return count

        
