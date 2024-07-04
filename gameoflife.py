"""
Time complexity: O(n)
Space Complexity: O(1)
"""

class Solution:
    def countAlive(self, board, row, column, dirarray, rowlen, columnlen):
        count = 0
        for i in dirarray:
            nrow = row + i[0]
            ncolumn = column + i[1]
            
            if(nrow >= 0 and nrow < rowlen and ncolumn >= 0 and ncolumn < columnlen and
               (board[nrow][ncolumn] == 1 or board[nrow][ncolumn] == 4)):
                count += 1
        return count
    
    def gameOfLife(self, board: list[list[int]]) -> None:
        rowlen = len(board)
        columnlen = len(board[0])
        
        dirarray = [[0,1], [0, -1], [-1,0], [1,0], 
                    [-1,1], [1,1], [-1,-1], [1,-1]]
        for i in range(rowlen):
            for j in range(columnlen):
                alives = self.countAlive(board, i, j, dirarray, rowlen, columnlen)
                
                if board[i][j] == 1:
                    if(alives > 3 or alives < 2):
                        board[i][j] = 4
                else:
                    if alives == 3:
                        board[i][j] = 3
                        
        for i in range(rowlen):
            for j in range(columnlen):
                if board[i][j] == 4:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
                    
        return board
