# Time Complexity : O(NM) (Where N is total rows and M is toatl columns in the board)
# Space Complexity : O(1) (We are doing all operations in place)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - When we change value of cell, we use some kind of marker other than given 2 values for dead and live cell.
# - Consider the new marker when counting the neightbour, and in the end replace marker with original value.


class Solution:
#   Function to count live neighbours.
    def countNeighbour(self, board, row, col):
#       Storing all directions
        dx = [-1,-1,-1,0,0,1,1,1]
        dy = [-1,0,1,-1,1,-1,0,1]
#       Initialzie count
        count = 0
#       Iterate over all directions that means take all neighbours one by one.
        for i in range(len(dx)):
#           Calculate neighbours row and column.
            nx = row + dx[i]
            ny = col + dy[i]
#           Check that neighbour is valid and cell is live using original value or marker.
            if 0 <= nx < len(board) and 0 <= ny < len(board[0]) and (board[nx][ny] == 1 or board[nx][ny] == -1):
#               If all conditions pass increament the count
                count += 1
#     return total neighbours count.
        return count
            
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
#       Iterate over each cell
        for row in range(len(board)):
            for col in range(len(board[0])):
#               Find no of live neighbours for that cell
                count = self.countNeighbour(board, row, col)
#               Change value fo cell according to the question and put marker for updated cell.
                if board[row][col] == 1:
                    if count < 2 or count > 3:
                        board[row][col] = -1  # 1 -> 0 : -1
                if board[row][col] == 0:
                    if count == 3:
                        board[row][col] = 2 # 0 -> 1: 2
                        
#       Change back marker value to original value
        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] == -1:
                    board[row][col] = 0
                if board[row][col] == 2:
                    board[row][col] = 1
