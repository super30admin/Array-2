class GameOfLife(object):
    '''
    Solution:
    1. To perform in-place, for each cell, if its updating from 1 to 0, make it 2 instead of 0 and if from 0 to 1, make
        it -2 instead of 1.
    2. Perform one more traversal to update 2 and -2 to 0 and 1 respectively so that each cell can check its neighbors
        without any issue.
    3. Return the updated board.

    --- Passed all testcases on leetcode successfully
    '''

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        # O(m*n) Time Complexity | O(1) Space Complexity
        m = len(board)
        if (board == None or m == 0):
            return
        n = len(board[0])

        for r in range(m):
            for c in range(n):
                countOnes = self.__countOnes(board, m, n, r, c)
                if (board[r][c] == 1 and (countOnes < 2 or countOnes > 3)):
                    board[r][c] = 2
                if (board[r][c] == 0 and countOnes == 3):
                    board[r][c] = -2

        for r in range(m):
            for c in range(n):
                if (board[r][c] == 2):
                    board[r][c] = 0
                if (board[r][c] == -2):
                    board[r][c] = 1

        return

    def __countOnes(self, board, m, n, r, c):

        # O(1) Time Complexity | O(1) Space Complexity
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1],
                [-1, -1], [-1, 1], [1, -1], [1, 1]]
        count = 0

        for direction in dirs:
            row = r + direction[0]
            col = c + direction[1]
            if (row >= 0 and row < m and col >= 0 and col < n):
                if (board[row][col] == 1 or board[row][col] == 2):
                    count += 1

        return count