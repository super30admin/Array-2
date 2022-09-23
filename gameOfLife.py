#Time Complexity: O(n^2)
#Space Complexity: O(n)
#Did it run on Leetcode: Yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])
        to_zero = []
        to_one = []
        dirs = [[-1, -1], [-1, 0], [-1, 1], [0, 1],
            [1, 1], [1, 0], [1, -1], [0, -1]]
        for i in range(row):
            for j in range(col):
                count = 0
                for l, r in dirs:
                    l += i
                    r += j
                    if 0 <= l < row and 0 <= r < col and board[l][r] == 1:
                        count += 1
                if board[i][j] == 1:
                    if count < 2:
                        to_zero.append((i, j))
                    elif count > 3:
                        to_zero.append((i, j))
                else:
                    if count == 3:
                        to_one.append((i, j))

        for i in to_zero:
            a, b = i
            board[a][b] = 0
        for i in to_one:
            a, b = i
            board[a][b] = 1
        