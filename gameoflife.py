#Time Complexity O(n^2)
#Space Complexity O(n)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        x = [[0]*len(board[0]) for i in range(len(board))]
        row = len(board)
        col = len(board[0])

        for i in range(row):
            for j in range(col):
                if board[i][j] == 1:
                    if 0 <= i-1 <= row-1 and 0 <= j-1 <= col-1:
                        x[i-1][j-1] += 1
                    if 0 <= i <= row-1 and 0 <= j-1 <= col-1:
                        x[i][j-1] += 1
                    if 0 <= i+1 <= row-1 and 0 <= j-1 <= col-1:
                        x[i+1][j-1] +=1

                    if 0 <= i-1 <= row-1 and 0 <= j <= col-1:
                        x[i-1][j] += 1
                    if 0 <= i+1 <= row-1 and 0 <= j <= col-1:
                        x[i+1][j] += 1

                    if 0 <= i-1 <= row-1 and 0 <= j+1 <= col-1:
                        x[i-1][j+1] += 1
                    if 0 <= i <= row-1 and 0 <= j+1 <= col-1:
                        x[i][j+1] += 1
                    if 0 <= i+1 <= row-1 and 0 <= j+1 <= col-1:
                        x[i+1][j+1] += 1

        # 1: 0,1 die
        # 1: 2,3 live
        # 1: 4,5,6,7,8 die
        # 0: 3 live

        for i in range(row):
            for j in range(col):
                if board[i][j] == 1 and x[i][j] in (0,1,4,5,6,7,8):
                    board[i][j] = 0
                elif board[i][j] == 0 and x[i][j] == 3:
                    board[i][j] = 1
