# Time Complexity: O(m*n)
# Space Complexity: O(1)


class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        self.dirs = [[0,1], [0,-1], [1,0], [-1,0], [-1,1], [1,1], [-1,-1], [1, -1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                neighboursCount = self.findNeighbours(board, i, j)
                if board[i][j] == 1:
                    if neighboursCount < 2 or neighboursCount > 3:
                        board[i][j] = 3

                else:
                    if neighboursCount == 3:
                        board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1

    def findNeighbours(self, board, i, j):
        count = 0
        for x, y in self.dirs:
            row = x + i
            col = y + j
            if 0<= row < len(board) and 0 <= col < len(board[0]):
                if board[row][col] == 1 or board[row][col] == 3:
                    count += 1
        return count
