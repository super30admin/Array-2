# Time complexity is O(m*n) where m and n are row and col of the input matrix
# Space complexity is O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row, col = len(board), len(board[0])
        if not board: return
#         1-->0 ==> 2
#         0-->1 ==> 3
#  The below function can also be written in a cartesian format as well. Cartesian or direction approach will reduce the time complexity of naviating the matrix
        def count_live_cells(r,c):
            nei = 0
            for i in range(r-1, r+2):
                for j in range(c-1, c+2):
                    if ((i == r and j == c) or i < 0 or j< 0 or i == row or j == col):# We dont need to check > row and > col because our loops are increasing by 1
                        continue
                    if board[i][j] in [1,2]:
                        nei += 1
            return nei

        for i in range(row):
            for j in range(col):
                count = count_live_cells(i,j)
                if board[i][j] == 1 and (count < 2 or count >3):
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
#         In the loop below we change the state back
        for i in range(row):
            for j in range(col):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
