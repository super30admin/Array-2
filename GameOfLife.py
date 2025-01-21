#Time complexity: O (m * n)
#Space complexity: O(1)
#Leetcode: Yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        self.m= len(board)
        self.n= len(board[0])

        for r in range(self.m):
            for c in range(self.n):
                neighbourcount = self.findNeighbours(board,r,c)
                if ( board[r][c] == 1):

                    if neighbourcount < 2 or neighbourcount > 3:
                        board[r][c]= 3
                else:
                    if neighbourcount == 3:
                        board[r][c]= 2
        for r in range(self.m):
            for c in range(self.n):
                if ( board[r][c] == 2):
                    board[r][c] = 1
                elif ( board[r][c] == 3):
                    board[r][c] = 0

        

    def findNeighbours(self,board,i,j):
        dirs= [[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1]]
        count=0
        for cord in dirs:
            row = i + cord[0]
            col = j + cord[1]
            if((row >=0) and (row < self.m) and (col >=0) and (col < self.n)):
                if(board[row][col] == 1 or board[row][col] == 3):
                    count = count +1
        return count

        