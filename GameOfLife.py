# // Time Complexity : O(n * m)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])

        def countLiveNeighbors(row, col):
            dirs = [(0, -1), (0, 1), (-1, 0), (1, 0),
                    (-1, -1), (-1, 1), (1, -1), (1, 1)]
            count = 0

            for r, c in dirs:
                r = row + r
                c = col + c
                # print(row,col,r,c)
                if (r >= 0 and r < rows) and (c >= 0 and c < cols):
                    # print(row,col,r,c)
                    if board[r][c] == 2 or board[r][c] == 1:
                        count = count + 1
            return count

        for row in range(rows):
            for col in range(cols):
                state = board[row][col]
                live = countLiveNeighbors(row, col)
                # print(row,col,live)
                if state == 2 or state == 1:
                    if live < 2:
                        board[row][col] = 2

                    if live > 3:
                        board[row][col] = 2
                else:
                    #       state == 0 or state == 3
                    if live == 3:
                        board[row][col] = 3

        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 3:
                    board[row][col] = 1
                if board[row][col] == 2:
                    board[row][col] = 0
