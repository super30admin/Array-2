def gameOfLife(self, board: List[List[int]]) -> None:
        height = len(board)
        length = len(board[0])
        cache = []

        # (A) looping through all cells in the board
        for i in range(height):
            for j in range(length):
                live_cells = 0

                # (B) getting count of cells around the cell we are currently at (board[i][j])
                for ii in range(max(0, i-1), min(i+2, height)):
                    for jj in range(max(0, j-1), min(j+2, length)):
						# (C) counting the number of alive cells around our current cell
                        if (ii, jj) == (i, j):
                            continue
                        if board[ii][jj] == 1:
                            live_cells +=1

                # (D) (E) saving the updated version of the board in our cache
                if board[i][j] == 1:
                    if live_cells < 2:
                        cache.append([i, j, 0])
                    elif live_cells <= 3:
                        cache.append([i, j, 1])
                    else:
                        cache.append([i, j, 0])
                else:
                    if live_cells == 3:
                        cache.append([i, j, 1])

        # (F) getting every change we need to do and applying to our board in place
        while cache:
            new_move = cache.pop()
            board[new_move[0]][new_move[1]] = new_move[2]

        return board
"""

    (A) The first loop is going to loop in every cell
    (B) The second loop is going to loop in all the cells that are around the one from the first loop
    (C) While in the second loop keep a count of the number of alive cells we are passing through
    (D) Check the current cell future state (0, 1) based on the number of alive cells around it and whether the current cell is alive
    (E) Save the current cell future state in our cache, we cant change its value now because it would affect other cells
    (F) Once we went through all cells, perform the operations saved on the cache
"""

Time complexity : O(nm)
Space complexity: O(1)        
