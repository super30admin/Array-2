'''
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m, n = len(board), len(board[0])

        def countAlive(i, j):
            dirs = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
            count = 0

            for row, col in dirs:
                r = i + row
                c = j + col

                if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] == 1 or board[r][c] == 2):
                    count += 1
            return count

        for i in range(0, m):
            for j in range(0, n):
                aliveCount = countAlive(i, j)
                if board[i][j] and (aliveCount < 2 or aliveCount > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and aliveCount == 3:
                    board[i][j] = 3
        
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1 