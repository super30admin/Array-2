#Time Complexity : O(m*n)
#Space Complexity : O(1)

class Solution:
    neighbours = [[1,0],[0,1],[1,1],[-1,0],[0,-1],[-1,-1],[1,-1],[-1,1]]
    def countAlive(self,i, j, board):
        m = len(board)
        n = len(board[0])
        result = 0
        for pair in range(len(self.neighbours)):
            row = i + self.neighbours[pair][0]
            col = j + self.neighbours[pair][1]
            
            if(row >= 0 and row < m and col >= 0 and col < n):
                if(board[row][col] == 2 or board[row][col] == 1):
                    result += 1
        return result
                
    
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        # 1- > 0 : 2
        #0 -> 1 : 3
        
        for i in range(m):
            for j in range(n):
                count = self.countAlive(i,j,board)
                if(board[i][j] == 0):
                    if(count == 3):
                        board[i][j] = 3
                    
                elif(board[i][j] == 1):
                    if (count > 3 or count < 2):
                        board[i][j] = 2
                    elif(count == 2 or count == 3):
                        board[i][j] = 1
        for i in range(m):
            for j in range(n):
                if(board[i][j] == 2):
                    board[i][j] = 0
                elif(board[i][j] == 3):
                    board[i][j] = 1
