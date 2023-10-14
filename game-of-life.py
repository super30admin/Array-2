# Intuition for in place
# 0 --> 1, set as 11
# 1 --> 0, set as 10

# TC: 2* O(m*n) = O(m*n)
# SC: O(1) no extra space used, original matrix mutated
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        # TC: O(m*n)
        for i in range(m):  # 0 to m-1
            for j in range(n):  # 0 to n-1

                countN = self.Neighbors(board, i, j, m, n)

                # conditions for the cell to live or die
                if board[i][j] == 1:
                    if countN < 2 or countN > 3:   # dies due to over or under population
                        board[i][j] = 10
                elif board[i][j] == 0:
                    if countN == 3:
                        board[i][j] = 11  # cell becomes alive

        # TC: O(m*n)
        # convert all 10s and 11s to 0s and 1s
        for i in range(m):  # 0 to m-1
            for j in range(n):  # 0 to n-1
                if board[i][j] == 10:
                    board[i][j] = 0
                elif board[i][j] == 11:
                    board[i][j] = 1
        return board

    # calculates 8 neighbors for each cell
    def Neighbors(self, board, i, j, m, n):
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1),
                      (0, 1), (1, -1), (1, 0), (1, 1)]
        neighbors = 0

        # TC: O(8) thus O(1)
        for d in directions:
            nr = i + d[0]
            nc = j + d[1]

            # for all valid vector, calculate neighbor. Note: 10 ~ 1
            if nr in range(0, m) and nc in range(0, n):
                if board[nr][nc] == 10 or board[nr][nc] == 1:
                    neighbors += 1

        return neighbors


obj = Solution()
k = obj.gameOfLife([[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]])
print(k)
