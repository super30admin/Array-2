"""
// Time Complexity : O(M * N) M rows , N cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

"""


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                countAlive = self.countalive(board, i, j, m, n)
                if board[i][j] == 1 and (countAlive < 2 or countAlive > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and countAlive == 3:
                    board[i][j] = 3

        print(board)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

    def countalive(self, board, i, j, m, n):
        result = 0
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        for each in dirs:
            r = i + each[0]
            c = j + each[1]
            if r >= 0 and c >= 0 and r < m and c < n and (board[r][c] == 1 or board[r][c] == 2):
                result += 1

        return result


