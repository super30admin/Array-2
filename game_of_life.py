# Time Complexity :O(m * n)
# Space Complexity: O(1)
class Solution(object):
    #     get count function for geting live cells count around current element
    def getCount(self, board, i, j, m, n):

        count = 0
        #                      r     l        b         u      br       bl     ur  ul
        direction = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        for k in direction:
            r = i + k[0]
            c = j + k[1]
            #             checking edge case conditions and if elmenet is alive we will update count
            if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] == 1 or board[r][c] == 3):
                count += 1

        return count

    def gameOfLife(self, board):

        m = len(board)  # row
        n = len(board[0])  # column
        #         updating cell value chnage with below values
        # 0 --> 1 2
        # 1 --> 0 3

        #         Iterate over matrix and based on rules update matrix values to 2 or 3
        for i in range(m):
            for j in range(n):
                count = self.getCount(board, i, j, m, n)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 2

        #         Again iterate over the matrix and chnage all 2 and 3 values to original one
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1

        return board

        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
