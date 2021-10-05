# Time Complexity : O(mn)
# Space Complexity : O(1) extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


#  Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                board[i][j] += 1

        for i in range(m):
            for j in range(n):

                isAlive = abs(board[i][j]) == 2
                count = 0

                for i1 in range(-1, 2):
                    for j1 in range(-1, 2):

                        if not (i1 == 0 and j1 == 0):
                            if -1 < i + i1 < m and -1 < j + j1 < n:

                                if abs(board[i + i1][j + j1]) == 2:
                                    count += 1

                if isAlive:
                    if count < 2 or count > 3:
                        board[i][j] = -board[i][j]

                else:
                    if count != 3:
                        board[i][j] = -board[i][j]

        for i in range(m):
            for j in range(n):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0

        return
