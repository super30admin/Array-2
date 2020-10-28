class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if len(board) == 0:
            return 0

        def lives(board, i, j):
            dirs = [[-1, 0], [-1, 1], [1, 0], [0, 1], [0, -1], [1, 1], [-1, -1], [1, -1]]
            count = 0
            for dir in dirs:
                r = i + dir[0]
                c = j + dir[1]
                if r >= 0 and c >= 0 and r < len(board) and c < len(board[0]) and (
                        board[r][c] == 1 or board[r][c] == 2):
                    count += 1
                # if board[r][c]==0 or board[r][c]==3:
                #     count+=0
            return count

        for i in range(len(board)):
            for j in range(len(board[0])):

                count = lives(board, i, j)

                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        # print(board)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0
        return board
        # time=O(n) and space-O(1)