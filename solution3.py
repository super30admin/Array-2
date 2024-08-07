# time: O(m*n)
# space: O(1)


class Solution(object):
    def checkState(self, i, j, board, dirs):
        sum1s = 0
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            
            if r >=0 and c >= 0 and r < len(board) and c < len(board[0]):
                if (board[r][c] == 1) or (board[r][c] == 3):
                    sum1s += 1

        if (board[i][j] == 0) and (sum1s == 3):
            return 2
        elif (board[i][j] == 1) and (sum1s > 3 or sum1s < 2):
            return 3
        else: 
            return board[i][j]

    def gameOfLife(self, board):
        # 0->1: 2
        # 1->0:3
        dirs = [[-1,0], [1,0], [0,-1], [0,1], [1,1], [-1,-1], [1,-1], [-1,1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] = self.checkState(i, j, board, dirs)
        print(board)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == 3:
                    board[i][j] = 0
        return board

    