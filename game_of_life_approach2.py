# Time complexity O(m*n) & space complexity is O(1) m,n = size of the input matrix

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row, col = len(board), len(board[0])
#       1 --> 0 ==>2
#       0 --> 1 ==>3
# To calculate the number of live errors using Cartesian/directional approach
        def count_live_cells(i,j):
            nums = [[-1,1],[0,1],[1,1],[-1,0],[1,0],[-1,-1],[0,-1],[1,-1]]
            nei = 0
            for num in nums:
                r = i + num[0]
                c = j + num[1]
                if (r >= 0 and c >=0 and r < row and c < col and (board[r][c] in [1,2])):
                    nei += 1
            return nei

        for i in range(row):
            for j in range(col):
                count = count_live_cells(i,j)
                if board[i][j] == 1 and (count<2 or count >3):
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
# State change to save space
        for i in range(row):
            for j in range(col):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1



