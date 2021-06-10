# Time Complexity :O(m * n)
# Space Complexity: O(1)

class Solution(object):
    def gameOfLife(self, board):
        m = len(board)
        n = len(board[0])
        # 0 -> 1 ->2
        # 1 -> 0 ->3

        for i in range(m):
            for j in range(n):
                count = self.getCount(board, i, j, m, n)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 2

        # change back to original case
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1

        return board

    # get live cells count around the current element
    def getCount(self, board, i, j, m, n):

        count = 0
        #                      r     l        b         u      br       bl     ur  ul
        direction = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        for k in direction:
            r = i + k[0]
            c = j + k[1]
            # check edge case. If alive we will update count
            if 0 <= r < m and 0 <= c < n and (board[r][c] == 1 or board[r][c] == 3):
                count += 1

        return count
