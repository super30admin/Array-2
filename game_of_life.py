#TC = O(n*m)
#SC = O(n*m)
#Compiled and run on Leetcode

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:


        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1) #find 8 neighboring cells

        rows = len(board)
        cols = len(board[0])


        for row in range(rows):
            for col in range(cols):

                live_neighbors = 0   #count the number of live neighbors.
                for neighbor in neighbors:


                    r = (row + neighbor[0])
                    c = (col + neighbor[1])


                    if (r < rows and r >= 0) and (c < cols and c >= 0) and abs(board[r][c]) == 1: #live cell
                        live_neighbors += 1


                if board[row][col] == 1 and (live_neighbors < 2 or live_neighbors > 3):  # Rule 1 or Rule 3

                    board[row][col] = -1

                if board[row][col] == 0 and live_neighbors == 3:    # Rule 4

                    board[row][col] = 2


        for row in range(rows):
            for col in range(cols):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0