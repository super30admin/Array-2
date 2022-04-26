# Time complexity: O(m * n) where m is the number of rows and n is the number of columns of the matrix.
# Space complexity: O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        # Local function to get the count of 1s
        def getCount(board, row, col):      
            dirs = ((0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1))   # (row, col) to check for neighbors.
            count = 0
            for direction in dirs:
                new_row = row + direction[0]
                new_col = col + direction[1]
                if new_row >= 0 and new_row < m and new_col >= 0 and new_col < n and  (board[new_row][new_col] == 1 or board[new_row][new_col] == 2):
                    count += 1

            return count
        
        if len(board) == 0: return
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                count = getCount(board, i, j)
                if board[i][j] == 1:        # Live
                    if count < 2 or count > 3:
                        board[i][j] = 2
                else:                       # Dead
                    if count == 3:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:        # Reverting the changes
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
                
        