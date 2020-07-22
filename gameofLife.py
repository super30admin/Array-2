# Time Complexity : O(n*m), where n is the number of rows and m is the number of columns
# Space Complexity : O(1), since the matrix was modified in place
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # since we also need to know the state of the neighbors as given,
    # replace 1 or 0 with place holder which will be modified later.
    # for every cell in the matrix compute the number of live neighbors
    # it has, and with the four rules given make the necessary changes.
    def __init__(self):
        self.n, self.m = -1, -1
    def gameOfLife(self, board):
        # 1 -> 0 -> 10
        # 0 -> 1 -> 11
        if not board: return []
        self.n, self.m = len(board), len(board[0])

        for i in range(self.n):
            for j in range(self.m):
                # function call to compute number of live neighbors
                live = self.countLive(board, i, j)
                # live cell
                if board[i][j] == 1:
                    # over or under population
                    if live < 2 or live > 3: board[i][j] = 10
                # dead cell
                else:
                    if live == 3: board[i][j] = 11
        # function call to replace placeholders
        self.replacePlaceholders(board)
        # the original function had no return type, this is for my own purpose.
        return board


    def countLive(self, board, i, j):
        count = 0
        neighbors = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, 1), (-1, -1), (1, 1), (1, -1)]
        for n in neighbors:
            r = i + n[0]
            c = j + n[1]
            if 0 <= r < self.n and 0 <= c < self.m and (board[r][c] == 1 or board[r][c] == 10):
                count += 1
        return count

    def replacePlaceholders(self, board):
        # replace place holders 10, 11 back to 0, 1
        for i in range(self.n):
            for j in range(self.m):
                if board[i][j] == 10: board[i][j] = 0
                elif board[i][j] == 11: board[i][j] = 1

print(Solution().gameOfLife([[0,1,0], [0,0,1], [1,1,1], [0,0,0]]))
