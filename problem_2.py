# TC: O(m*n)
# SC: O(1)

def gameOfLife(board):
        """
        Do not return anything, modify board in-place instead.
        """

        m = len(board)
        n = len(board[0])

        def neighbour_count(board, i, j):
            # topleft, top, topright, right, bottomright, bottom, bottomleft, left
            d = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]
            count = 0
            for x in d:
                tx = i + x[0]
                ty = j + x[1]
                print(tx, ty)
                if tx >= 0 and ty >= 0 and tx < len(board) and ty < len(board[0]):
                    if board[tx][ty] == 1 or board[tx][ty] == 13:
                        count += 1
            return count

        for i in range(m):
            for j in range(n):
                count = neighbour_count(board, i, j)
                if board[i][j] == 1:
                    if count > 3 or count < 2:
                        board[i][j] = 13 # It dies
                elif board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 14 # It gets alive
        

        for i in range(m):
            for j in range(n):
                if board[i][j] == 14:
                    board[i][j] = 1
                elif board[i][j] == 13:
                    board[i][j] = 0
        return board


input = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
print(gameOfLife(input))