# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
#To do it inplace, change the state to a random number for live to die and vice versa
#Use a count function to count all the neighbors with the help of dirs array
#Update at the end from the random numbers to the final state
class Solution:
    def count(self, board, row, col):
        result = 0
        dirs = [[1,-1],[1,0],[1,1],[0,-1],[-1,-1],[-1,0],[-1,1],[0,1]]
        for dir in dirs:
            newRow = row + dir[0]
            newCol = col + dir[1]
            
            if (0 <= newRow < len(board)) and (0 <= newCol < len(board[0])) and (board[newRow][newCol] == 1 or board[newRow][newCol] == 2):
                result += 1
                           
        return result
                                                                          
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0 or board == None:
            return
        
        
        # 0 --> 1 - 3 (die to live)
        # 1 --> 0 - 2 (live to die)
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                if board[i][j] == 1:
                    lives = self.count(board, i , j)
                    if (lives > 3 or lives < 2):
                        board[i][j] = 2
                        
                        
                elif board[i][j] == 0:
                    lives = self.count(board, i , j)
                    if lives == 3:
                        board[i][j] = 3
                        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0
                    
        return board
                
    
                                                         
                    
                    
        