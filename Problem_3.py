# Time Complexity: O(m * n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                live = 0
                for x in range(max(0, (i - 1)), min(m, (i + 2))):
                    for y in range(max(0, (j - 1)), min(n, (j + 2))):
                        live += (board[x][y] & 1)
                if (board[i][j] == 1) and ((live == 3) or (live == 4)):
                    board[i][j] |= 0b10
                if (board[i][j] == 0) and (live == 3):
                    board[i][j] |= 0b10
        for i in range(m):
            for j in range(n):
                board[i][j] >>= 1