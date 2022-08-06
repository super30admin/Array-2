#  289. Game of Life
'''
Leetcode all test cases passed: Yes
class Solution:
  def gameOfLife(self, board: List[List[int]]) -> None:
        n is the no of rows in board
        n is the no of columns in board
        Space Complexity: O(1)
        Time Complexity: O(m * n)
'''
class Solution:
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        x_offset = [-1,-1,-1,0,0,1,1,1]
        y_offset = [-1,0,1,-1,1,-1,0,1]
        
        no_of_rows = len(board)
        no_of_columns = len(board[0])
        for i in range(no_of_rows):
            for j in range(no_of_columns):
                neighbour_count = 0
                for x_off,y_off in zip(x_offset,y_offset):
                    if i + x_off < 0 or i + x_off >= no_of_rows or  j + y_off < 0 or j + y_off >= no_of_columns:
                        continue
                    if abs(board[i + x_off][j + y_off]) == 1:
                        neighbour_count += 1
                
            
                if board[i][j] == 1:
                    if 3 < neighbour_count or neighbour_count < 2:
                        board[i][j] = -board[i][j]
                else:
                    if neighbour_count == 3:
                        board[i][j] = 2
        
        for i in range(no_of_rows):
            for j in range(no_of_columns):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        return board
