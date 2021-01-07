


def gameOfLife(board):

    # Null Checks

    if not board or board == None:
        return

    m = len(board) - 1
    n = len(board[0]) - 1

    # mapping
    # 1 ---> 0 (alive to dead, mark as 2)
    # 0 ---> 1 (dead to alive, mark as 3)

    # 1st pass --> perform temporary state change
    for i in range(len(board)):
        for j in range(len(board[0])):

            liveCellsCount = countLiveCells(board, i, j, m, n)

            if (board[i][j] == 1) and (liveCellsCount < 2) or (liveCellsCount > 3):
                # case alive becomes dead, so update as 2
                board[i][j] == 2


            elif (board[i][j] == 0) and l(iveCellsCount == 3):
                # case where dead becomes alive, update as 3
                board[i][j] == 3


    # Pass 2 - Based on temporary state change, analyze which states changed and revert back to 0 and 1 to match expected output     
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 2:
                board[i][j] = 0 # since 2 represents it became dead

            if board[i][j] == 3:
                board[i][j] = 1 # since 3 represents it became alive

    
    def countLiveCells(board, i, j, m, n):

        count = 0
        directions = [[0,1],[0,-1],[-1,0],[-1,-1],[-1,1],[1,0],[1,1],[1,-1]]

        for neighbor in directions:
            row = i + neighbor[0]
            col = j + neighbor[1]

            # boundary checks
            if (row >= 0) and (row <= m) and (col >= 0) and (col <= n):
                if board[row][col] == 1 or board[row][col] == 2: # we check 2 since it represents state where it initially was 1
                    count += 1

        return count


