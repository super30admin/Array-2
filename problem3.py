'''
Time Complexity :O(m*n)
Space Complexity: O(1) Inplace
Did this code successfully run on Leetcode : Yes
Explanation:
Iterate the matrix using the rules, mark alive in next state by setting alive in next state to 2 and dead as -1 now check all the
rules and check previous state to check the rules
'''


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0:
            return

        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                count = self.countNeighbors(board, i, j)

                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = -1
                else:
                    if count == 3:
                        board[i][j] = 2
        print(board)
        # replace 2 and 1 with 1 and 0
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == -1:
                    board[i][j] = 0

    def countNeighbors(self, board: List[List[int]], i: int, j: int) -> int:
        # i-1, j-1, i-1, j, i-1, j+1
        # i, j-1    i, j    i, j+1
        # i+1,j-1   i+1,j   i+1, j+1
        dx = [-1, -1, -1, 0, 0, 1, 1, 1]
        dy = [-1, 0, 1, -1, 1, -1, 0, 1]
        row = col = 0
        neighbors = 0
        for k in range(0, 8):
            row = i + dx[k]
            col = j + dy[k]
            if self.isValid(board, row, col):
                if board[row][col] == 1 or board[row][col] == -1:
                    neighbors += 1

        return neighbors

    def isValid(self, board: List[List[int]], row: int, col: int) -> bool:
        return row >= 0 and col >= 0 and row < len(board) and col < len(board[0])