class Solution:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def liveCoins(i, j):
            count = 0
            dirs = [[-1,0], [1,0], [0,-1], [0,1], [1,1], [1,-1], [-1,1], [-1,-1]]
            for dir in dirs:
                x = i+dir[0]
                y = j+dir[1]
                if x >=0 and x < len(board) and y >=0 and y < len(board[0]) and (board[x][y] == 1 or board[x][y] == 2):
                    count += 1
            return count

        for i in range(len(board)):
            for j in range(len(board[0])):
                livecoins = liveCoins(i,j)
                if board[i][j] == 1 and (livecoins < 2 or livecoins > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and livecoins == 3:
                    board[i][j] = 3
        print(board)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

#TC: O(n*m)
#SC: O(n*m)