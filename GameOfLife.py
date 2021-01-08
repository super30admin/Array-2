# TC = O(mn)
# SC = O(1)
# We are mutating the original matrix with 2 for alive, with 3 for dead. Go over the matrix to replace 2 with 0 and 3 with 1. 
def game(board):
    if not board or len(board) == 0: return
    m = len(board)
    n = len(board[0])
    def countLives(board, i,j):
        count = 0
        dirs = [[0,1], [0,-1], [-1,0], [1,0], [-1,-1], [-1,1], [1,1], [1,-1]]
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            if r>= 0 and c>= 0 and r < m and c < n and (board[r][c] ==1 or board[r][c] == 2): count += 1
        return count
    for i in range(m):
        for j in range(n):
            count = countLives(board,i,j)
            if board[i][j] == 1 and (count < 2 or count > 3):
                board[i][j] = 2
            if board[i][j] == 0 and count == 3:
                board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0
    return board
    
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
print(game(board))