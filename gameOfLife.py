# Time complexity: O(M*N)
# Space complexity: O(1) Because we are modifying the input array in place
# Compiled on leetcode: Yes
# Difficulties: No
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                count = self.countLives(board, i, j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = -1
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 2
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
        
        
   
    def countLives(self,board, i, j):
        lives = 0
        directions = [[-1,0], [1,0], [0, -1], [0, 1], [1, -1], [1, 1], [-1, 1], [-1,-1]]
        for direction in directions:
            row = direction[0] + i
            column = direction[1] + j
            if row >=0 and row < len(board) and column >= 0 and column < len(board[0]):
                if board[row][column] == 1 or board[row][column] == -1:
                    lives += 1
        return lives            
        