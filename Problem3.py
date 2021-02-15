"""
289. Game of Life
Time Complexity - O(n*m)
Space Complexity - O(1)
Traversed through each row and column of input matrix
    defined a function to count no of adjacent 1's to a element
    if value is equal to 1 and count is less than 2 or greater than 3(as mentioned in problem statement)
        Replace it by 2(i.e. That element turned alive -> dead)
    elif value is equal to 0 and count is greater than 3 then
     Replace that element by 3(i.e. That element turned dead -> alive)
Then replace all 2's by 0 and 3's by 1

"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        if board == None or len(board) == 0  or len(board[0])== 0:
            return
        rows = len(board)
        columns = len(board[0])
        
        for row in range(0,rows):
            for column in range(0,columns):
                count = self.live_counter(board,row,column,rows,columns)
                
                if board[row][column] == 1 and (count < 2 or count > 3):
                    board[row][column] = 2
                elif board[row][column] == 0 and count == 3:
                    board[row][column] = 3
        
        for row in range(0,rows):
            for column in range(0,columns):  
                if board[row][column] == 3:
                    board[row][column] = 1
                elif board[row][column] == 2:
                    board[row][column] = 0
        
    def live_counter(self,board,row,column,rows,columns):
        count = 0
        direction = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]
        for item in direction:
            r = row + item[0]
            c = column + item[1]
            if r >= 0 and r < rows and c >= 0 and c < columns and (board[r][c] == 1 or board[r][c] == 2):
                count += 1    
        return count
                    
        