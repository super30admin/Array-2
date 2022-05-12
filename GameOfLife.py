'''
time complexity: O(M*N)
M - rows, N- Columns
space complexity: O(1)
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        column = len(board[0])
        
        for i in range(row):
            for j in range(column):
                
                oneCount = 0
                if i > 0 and (board[i - 1][j] == 1 or board[i - 1][j] == 2):
                    oneCount+=1
                if i < row - 1 and (board[i + 1][j] == 1 or board[i + 1][j] == 2):
                    oneCount += 1
                if j < column - 1 and (board[i][j + 1] == 1 or board[i][j + 1] == 2):
                    oneCount+=1
                if j > 0 and (board[i][j - 1] == 1 or board[i][j - 1] == 2):
                    oneCount+=1
                
                if i < row - 1 and j < column - 1 and (board[i + 1][j + 1] == 1 or board[i + 1][j + 1] == 2):
                    oneCount+=1
                if i > 0 and j > 0 and (board[i - 1][j - 1] == 1 or board[i - 1][j - 1] == 2):
                    oneCount+=1
                if i > 0 and j < column - 1 and (board[i - 1][j + 1] == 1 or board[i - 1][j + 1] == 2):
                    oneCount+=1
                if i < row - 1 and j > 0 and (board[i + 1][j - 1] == 1 or board[i + 1][j - 1] == 2):
                    oneCount+=1
                 

                if board[i][j] == 1:
                    if oneCount < 2:
                        board[i][j] = 2
                    elif oneCount > 3:
                        board[i][j] = 2
                else:
                    if oneCount == 3:
                        board[i][j] = 3

        for i in range(row):
            for j in range(column):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

