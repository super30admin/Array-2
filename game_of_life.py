# Time Complexity: O(mn) where m is the number of rows and n is the number of columns
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not len(board):
            return
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = self.helper(board, i, j)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
                elif board[i][j] == 1 and (count != 3 and count != 2):
                    board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    
    def helper(self, board, row, column):
        comb = {0: 0, 1: 1, 2: 1, 3: 0}
        dirs = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
        count = 0
        for elem in dirs:
            i = row + elem[0]
            j = column + elem[1]
            if (i >= 0 and i < len(board) and j >= 0 and j < len(board[0])):
                count += comb[board[i][j]]
        return count
                