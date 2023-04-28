# Problem2 (https://leetcode.com/problems/game-of-life/)
# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Iterate over the matrix and for each element, count the number of live neighbors. If the element is live and
# the number of live neighbors is less than 2 or greater than 3, mark the element as 2. If the element is dead and the
# number of live neighbors is 3, mark the element as 3. Iterate over the matrix again and mark the elements with value
# 2 as 0 and elements with value 3 as 1.

class Solution(object):
    def gameOfLife(self, board):
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = self.countLiveNeighbors(board, i, j, m, n)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        return board

    def countLiveNeighbors(self, board, i, j, m, n):
        result = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] == 1 or board[r][c] == 2):
                result += 1
        return result