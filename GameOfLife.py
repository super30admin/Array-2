# Time complexity is O(m*n) n is number of rows and m is number of columns
# Space complexity is O(1) we do not use extra space for computation

class Solution:

    # In solution I will iterate over matrix and get neighbours alive count
    # if alive neighbours > 3 and < 2 make alive to dead
    # if dead neighbours == 3 make dead alive
    # In our case we gonna convert 1 -> 0 with -2 and 0 -> 1 with 2
    # I will neighbours and -2 as well
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rowLen = len(board)
        colLen = len(board[0])

        for i in range(rowLen):
            for j in range(colLen):
                aliveCount = self.getAliveNeighboursCount(
                    board, i, j, rowLen, colLen)
                if (aliveCount > 3 or aliveCount < 2) and board[i][j] == 1:
                    board[i][j] = -2
                elif aliveCount == 3 and board[i][j] == 0:
                    board[i][j] = 2

        for i in range(rowLen):
            for j in range(colLen):
                if board[i][j] == -2:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1

    def getAliveNeighboursCount(self, board, i, j, rowLen, colLen):
        dirs = [[-1, -1], [-1, 0], [-1, 1], [0, -1],
                [0, 1], [1, -1], [1, 0], [1, 1]]
        count = 0
        for l in dirs:
            r = i + l[0]
            c = j + l[1]
            if (r >= 0 and r < rowLen) and (c >= 0 and c < colLen):
                if board[r][c] == 1 or board[r][c] == -2:
                    count += 1
        return count
