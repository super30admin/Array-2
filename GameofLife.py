# Time Complexity : O(MN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Check count of all the neighbors of each cell and assign 2 if the cell is 1 and 3 if the cell is 0.
# Then assign 3 to 1 and 2 to 0 for the output


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = self.checkNeighbors(board, i, j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                if (board[i][j] == 0 and count == 3):
                    board[i][j] = 3
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0

    def checkNeighbors(self, board, i, j):
        count = 0
        neighbors = [(0, 1), (0, -1), (-1, 0), (1, 0), (-1, -1), (-1, 1),
                     (1, 1), (1, -1)]
        for neighbor in neighbors:
            row = i + neighbor[0]
            col = j + neighbor[1]
            if row >= 0 and col >= 0 and row < len(board) and col < len(
                    board[0]) and (board[row][col] == 1
                                   or board[row][col] == 2):
                count += 1
        return count
