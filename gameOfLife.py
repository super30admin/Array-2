"""
289. Game of Life

Time = O(mn); m = number of row n = number of coloumn
space = O(1); constant space, in-space modification
Successfully excecuted on leetcode


Approach - 

1. Calculate live neighbors for each cell in the board
2. If the cell value = 1, check how many neighbors alive and follow rule 1 and 3, update value to negative according to this rules
3. If the cell value = 0, check if 3 neighbors are alive then update value to 2, to notify the dead cell became alive

"""

class Game:
    def gameOfLife(self, board: List[List[int]]) -> None:
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        rows = len(board)
        cols = len(board[0])

        for row in range(rows):
            for col in range(cols):            
                live_neighbors = 0
                for neighbor in neighbors:
                    # row and coloumn of neighbor
                    r = (row + neighbor[0])
                    c = (col + neighbor[1])

                    # check the row and columns are valid
                    if (r < rows and r >= 0) and (c < cols and c >= 0) and abs(board[r][c]) == 1:
                        live_neighbors += 1

                if board[row][col] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[row][col] = -1 # negative value to signify cell is dead now but was originally alive
                if board[row][col] == 0 and live_neighbors == 3:
                    board[row][col] = 2 # 2 to signify cell is now live but was originally dead

        for row in range(rows):
            for col in range(cols):
                if board[row][col] >= 1:
                    board[row][col] = 1
                else:
                    board[row][col] = 0