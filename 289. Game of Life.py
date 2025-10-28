# Time: O(m*n)
# Space: O(1)
# Description => According to the given conditions update either 1 to 0 or 0 to 1
# Have a seperate function to count the ones around a particular element
# Then in the first pass on the matrix make the changes but don't directy change it to either 0 or 1 because we want to compare everything with the earlier state of the matrix
# So instead change it to 4 if it's turned from 1 to 0 and 5 if it's 0 to 1 (Remember to count the 4's too in the counter function)
# In the next pass change 4 and 5 to 0 nd 1 respectively

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count_alives = self.count_alive(board,i,j)
                if board[i][j] == 1:
                    if count_alives < 2:
                        board[i][j] = 4
                    elif count_alives > 3:
                        board[i][j] = 4
                elif board[i][j] == 0:
                    if count_alives == 3:
                        board[i][j] = 5
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 4:
                    board[i][j] = 0
                elif board[i][j] == 5:
                    board[i][j] = 1

    def count_alive(self,board,i,j):
            directions = [
                    (0, 1),   # Up
                    (0, -1),  # Down
                    (1, 0),   # Right
                    (-1, 0),  # Left
                    (1, 1),   # Up-Right
                    (1, -1),  # Down-Right
                    (-1, 1),  # Up-Left
                    (-1, -1)  # Down-Left
                ]
            count = 0
            for direc in directions:
                new_row = i + direc[0]
                new_col = j + direc[1]
                if new_row >= 0 and new_col >= 0 and new_row < len(board) and new_col < len(board[0]):
                    if board[new_row][new_col] == 1 or board[new_row][new_col] == 4:
                        count += 1
            return count