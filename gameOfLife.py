# Time Complexity : O(M*N) where M is number of rows and N is number of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : took a lot of time to get it right
class Solution:
    def gameOfLife(self, board: [int]):
        # edge case
        if not board or len(board) == 0:
            return
        # 0 --> 1 : denoted by 3; alive now
        # 1 --> 0 : denoted by 2; dead now
        rows = len(board)
        cols = len(board[0])
        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0), (-1, -1), (1, -1), (-1, 1), (1, 1)]
        for x in range(rows):
            for y in range(cols):
                livingCount = 0
                for dx, dy in dirs:
                    r = x + dx
                    c = y + dy
                    if (0 <= r < rows) and (0 <= c < cols) and (board[r][c] == 1 or board[r][c] == 2):
                        livingCount += 1

                if board[x][y] == 0 and livingCount == 3:
                    board[x][y] = 3  # alive now
                elif board[x][y] == 1 and (livingCount < 2 or livingCount > 3):
                    board[x][y] = 2  # dead now

        for x in range(rows):
            for y in range(cols):
                board[x][y] = board[x][y] % 2  # get 1 or 0 from 2 and 3
        return board


r = Solution()
board = [
    [0, 1, 0],
    [0, 0, 1],
    [1, 1, 1],
    [0, 0, 0]
]
print(r.gameOfLife(board))
