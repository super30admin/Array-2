# Time Complexity is O(MN), where M Number of rows and N number of columns
# Space complexity is O(1), since we are using the same board to mark the changed values
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        
        1->0 : 2
        0->1 : 3
        """
        def val(i,j):
            if(0 <= i < len(board) and 0<= j < len(board[0])):
                if(board[i][j] == 2):
                    return 1
                elif(board[i][j] == 3):
                    return 0
                return board[i][j]
            return 0
        
        def count(i,j):
            return val(i-1,j-1) + val(i-1,j) + val(i-1,j+1) + val(i,j-1) + val(i,j+1) + val(i+1,j-1) + val(i+1,j) + val(i+1,j+1)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(val(i,j) == 0 and count(i,j) == 3):
                    board[i][j] = 3
                elif(val(i,j) == 1):
                    if(count(i,j) < 2 or count(i,j) > 3):
                        board[i][j] = 2
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(board[i][j] == 2):
                    board[i][j] = 0
                elif(board[i][j] == 3):
                    board[i][j] = 1