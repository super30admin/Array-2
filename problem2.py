#Time Complexity O(N*M)
#Space Complexity O(1) constant
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        nb = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]

        rows = len(board)
        cols = len(board[0])

        
        for row in range(rows):
            for col in range(cols):
                live_nb = 0
                for neighbor in nb:
                    r = (row + neighbor[0])
                    c = (col + neighbor[1])

                    if (r < rows and r >= 0) and (c < cols and c >= 0) and abs(board[r][c]) == 1:
                        live_nb += 1

                # Rule 1 or Rule 3
                if board[row][col] == 1 and (live_nb < 2 or live_nb > 3):
                    board[row][col] = -1
                # Rule 4
                if board[row][col] == 0 and live_nb == 3:
                    board[row][col] = 2

        for row in range(rows):
            for col in range(cols):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0
