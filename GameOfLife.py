#All TC passed on leetcode

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #Here we follow the rules given to get next gen o/p. 
        #To modify in place we keep track of prev value by adding 2 if 0 canged to 1. 
        #Similarly we put 3 if 1 changed to 0.
        #Time complexity - O(m.n) where m=rows, n=cols
        #Space complexity - O(1) as we modify in place
        rows = len(board)
        cols = len(board[0])


        #0->1 => 2
        #1->0 => 3
        for i in range(rows):
            for j in range(cols):
                countAlive = self.getCountAlive(board, i, j, rows, cols)
                if board[i][j]==1 and (countAlive<2 or countAlive>3):
                    board[i][j] = 3
                elif board[i][j]==0 and countAlive==3:
                    board[i][j] = 2

        for i in range(rows):
            for j in range(cols):
                if board[i][j]==2:
                    board[i][j] = 1
                if board[i][j]==3:
                    board[i][j] = 0
        
        return 


    def getCountAlive(self, board, i, j, rows, cols):
        directions = [[-1,0], [1,0], [0,-1], [0,1], [1,1], [-1,-1], [-1,1], [1,-1]]
        count = 0
        for dir in directions:
            nr = i+dir[0]
            nc = j+dir[1]
            if nr<rows and nc<cols and nr>=0 and nc>=0 and (board[nr][nc]==1 or board[nr][nc]==3):
                count+=1
        return count
                